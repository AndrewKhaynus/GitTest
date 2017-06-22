package website.radomar.git_test.presentation.dialog;

import android.content.Context;
import android.widget.TextView;

import website.radomar.git_test.R;
import website.radomar.git_test.presentation.base.BaseDialog;

/**
 * Created by Radomar on 20.06.2017.
 */

public class ErrorDialog extends BaseDialog<ErrorDialogPresenter> {

    private TextView tvMessage;
    private TextView buttonOk;

    private ErrorDialog(Context context, String message) {
        super(context);
        setCancelable(false);
        findUI();
        tvMessage.setText(message);
    }

    @Override
    public ErrorDialogPresenter createPresenter() {
        return new ErrorDialogPresenter();
    }

    @Override
    public void findUI() {
        tvMessage   = (TextView) findViewById(R.id.tvMessageDialog);
        buttonOk    = (TextView) findViewById(R.id.btnOkDialog);
        buttonOk.setOnClickListener(view -> presenter.closeDialog());
    }

    @Override
    public int getLayoutRes() {
        return R.layout.dialog_message;
    }

    public static ErrorDialog create(Context context, String message) {
        return new ErrorDialog(context, message);
    }
}
