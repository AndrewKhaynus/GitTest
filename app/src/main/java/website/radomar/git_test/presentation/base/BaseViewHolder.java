package website.radomar.git_test.presentation.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Radomar on 20.06.2017.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    protected T mDataItem;

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public void updateItem(final T data) {
        mDataItem = data;
        contentUpdate(mDataItem);
    }

    protected abstract void findUi();

    protected abstract void contentUpdate(final T dataItem);
}
