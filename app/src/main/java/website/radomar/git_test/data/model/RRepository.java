package website.radomar.git_test.data.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Radomar on 21.06.2017.
 */

public class RRepository extends RealmObject {

    public String searchQuery;

    @PrimaryKey
    public int id;

    public String name;
    public String fullName;
//    public Owner owner;
    public boolean privateX;
    public String htmlUrl;
    public String description;
    public boolean fork;
    public String url;
    public String forksUrl;
    public String keysUrl;
    public String collaboratorsUrl;
    public String teamsUrl;
    public String hooksUrl;
    public String issueEventsUrl;
    public String eventsUrl;
    public String assigneesUrl;
    public String branchesUrl;
    public String tagsUrl;
    public String blobsUrl;
    public String gitTagsUrl;
    public String gitRefsUrl;
    public String treesUrl;
    public String statusesUrl;
    public String languagesUrl;
    public String stargazersUrl;
    public String contributorsUrl;
    public String subscribersUrl;
    public String subscriptionUrl;
    public String commitsUrl;
    public String gitCommitsUrl;
    public String commentsUrl;
    public String issueCommentUrl;
    public String contentsUrl;
    public String compareUrl;
    public String mergesUrl;
    public String archiveUrl;
    public String downloadsUrl;
    public String issuesUrl;
    public String pullsUrl;
    public String milestonesUrl;
    public String notificationsUrl;
    public String labelsUrl;
    public String releasesUrl;
    public String deploymentsUrl;
    public String createdAt;
    public String updatedAt;
    public String pushedAt;
    public String gitUrl;
    public String sshUrl;
    public String cloneUrl;
    public String svnUrl;
    public int size;
    public int stargazersCount;
    public int watchersCount;
    public String language;
    public boolean hasIssues;
    public boolean hasDownloads;
    public boolean hasWiki;
    public boolean hasPages;
    public int forksCount;
    public int openIssuesCount;
    public int forks;
    public int openIssues;
    public int watchers;
    public String defaultBranch;
    public double score;

    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isPrivateX() {
        return privateX;
    }

    public void setPrivateX(boolean privateX) {
        this.privateX = privateX;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFork() {
        return fork;
    }

    public void setFork(boolean fork) {
        this.fork = fork;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getForksUrl() {
        return forksUrl;
    }

    public void setForksUrl(String forksUrl) {
        this.forksUrl = forksUrl;
    }

    public String getKeysUrl() {
        return keysUrl;
    }

    public void setKeysUrl(String keysUrl) {
        this.keysUrl = keysUrl;
    }

    public String getCollaboratorsUrl() {
        return collaboratorsUrl;
    }

    public void setCollaboratorsUrl(String collaboratorsUrl) {
        this.collaboratorsUrl = collaboratorsUrl;
    }

    public String getTeamsUrl() {
        return teamsUrl;
    }

    public void setTeamsUrl(String teamsUrl) {
        this.teamsUrl = teamsUrl;
    }

    public String getHooksUrl() {
        return hooksUrl;
    }

    public void setHooksUrl(String hooksUrl) {
        this.hooksUrl = hooksUrl;
    }

    public String getIssueEventsUrl() {
        return issueEventsUrl;
    }

    public void setIssueEventsUrl(String issueEventsUrl) {
        this.issueEventsUrl = issueEventsUrl;
    }

    public String getEventsUrl() {
        return eventsUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    public String getAssigneesUrl() {
        return assigneesUrl;
    }

    public void setAssigneesUrl(String assigneesUrl) {
        this.assigneesUrl = assigneesUrl;
    }

    public String getBranchesUrl() {
        return branchesUrl;
    }

    public void setBranchesUrl(String branchesUrl) {
        this.branchesUrl = branchesUrl;
    }

    public String getTagsUrl() {
        return tagsUrl;
    }

    public void setTagsUrl(String tagsUrl) {
        this.tagsUrl = tagsUrl;
    }

    public String getBlobsUrl() {
        return blobsUrl;
    }

    public void setBlobsUrl(String blobsUrl) {
        this.blobsUrl = blobsUrl;
    }

    public String getGitTagsUrl() {
        return gitTagsUrl;
    }

    public void setGitTagsUrl(String gitTagsUrl) {
        this.gitTagsUrl = gitTagsUrl;
    }

    public String getGitRefsUrl() {
        return gitRefsUrl;
    }

    public void setGitRefsUrl(String gitRefsUrl) {
        this.gitRefsUrl = gitRefsUrl;
    }

    public String getTreesUrl() {
        return treesUrl;
    }

    public void setTreesUrl(String treesUrl) {
        this.treesUrl = treesUrl;
    }

    public String getStatusesUrl() {
        return statusesUrl;
    }

    public void setStatusesUrl(String statusesUrl) {
        this.statusesUrl = statusesUrl;
    }

    public String getLanguagesUrl() {
        return languagesUrl;
    }

    public void setLanguagesUrl(String languagesUrl) {
        this.languagesUrl = languagesUrl;
    }

    public String getStargazersUrl() {
        return stargazersUrl;
    }

    public void setStargazersUrl(String stargazersUrl) {
        this.stargazersUrl = stargazersUrl;
    }

    public String getContributorsUrl() {
        return contributorsUrl;
    }

    public void setContributorsUrl(String contributorsUrl) {
        this.contributorsUrl = contributorsUrl;
    }

    public String getSubscribersUrl() {
        return subscribersUrl;
    }

    public void setSubscribersUrl(String subscribersUrl) {
        this.subscribersUrl = subscribersUrl;
    }

    public String getSubscriptionUrl() {
        return subscriptionUrl;
    }

    public void setSubscriptionUrl(String subscriptionUrl) {
        this.subscriptionUrl = subscriptionUrl;
    }

    public String getCommitsUrl() {
        return commitsUrl;
    }

    public void setCommitsUrl(String commitsUrl) {
        this.commitsUrl = commitsUrl;
    }

    public String getGitCommitsUrl() {
        return gitCommitsUrl;
    }

    public void setGitCommitsUrl(String gitCommitsUrl) {
        this.gitCommitsUrl = gitCommitsUrl;
    }

    public String getCommentsUrl() {
        return commentsUrl;
    }

    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

    public String getIssueCommentUrl() {
        return issueCommentUrl;
    }

    public void setIssueCommentUrl(String issueCommentUrl) {
        this.issueCommentUrl = issueCommentUrl;
    }

    public String getContentsUrl() {
        return contentsUrl;
    }

    public void setContentsUrl(String contentsUrl) {
        this.contentsUrl = contentsUrl;
    }

    public String getCompareUrl() {
        return compareUrl;
    }

    public void setCompareUrl(String compareUrl) {
        this.compareUrl = compareUrl;
    }

    public String getMergesUrl() {
        return mergesUrl;
    }

    public void setMergesUrl(String mergesUrl) {
        this.mergesUrl = mergesUrl;
    }

    public String getArchiveUrl() {
        return archiveUrl;
    }

    public void setArchiveUrl(String archiveUrl) {
        this.archiveUrl = archiveUrl;
    }

    public String getDownloadsUrl() {
        return downloadsUrl;
    }

    public void setDownloadsUrl(String downloadsUrl) {
        this.downloadsUrl = downloadsUrl;
    }

    public String getIssuesUrl() {
        return issuesUrl;
    }

    public void setIssuesUrl(String issuesUrl) {
        this.issuesUrl = issuesUrl;
    }

    public String getPullsUrl() {
        return pullsUrl;
    }

    public void setPullsUrl(String pullsUrl) {
        this.pullsUrl = pullsUrl;
    }

    public String getMilestonesUrl() {
        return milestonesUrl;
    }

    public void setMilestonesUrl(String milestonesUrl) {
        this.milestonesUrl = milestonesUrl;
    }

    public String getNotificationsUrl() {
        return notificationsUrl;
    }

    public void setNotificationsUrl(String notificationsUrl) {
        this.notificationsUrl = notificationsUrl;
    }

    public String getLabelsUrl() {
        return labelsUrl;
    }

    public void setLabelsUrl(String labelsUrl) {
        this.labelsUrl = labelsUrl;
    }

    public String getReleasesUrl() {
        return releasesUrl;
    }

    public void setReleasesUrl(String releasesUrl) {
        this.releasesUrl = releasesUrl;
    }

    public String getDeploymentsUrl() {
        return deploymentsUrl;
    }

    public void setDeploymentsUrl(String deploymentsUrl) {
        this.deploymentsUrl = deploymentsUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPushedAt() {
        return pushedAt;
    }

    public void setPushedAt(String pushedAt) {
        this.pushedAt = pushedAt;
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public void setGitUrl(String gitUrl) {
        this.gitUrl = gitUrl;
    }

    public String getSshUrl() {
        return sshUrl;
    }

    public void setSshUrl(String sshUrl) {
        this.sshUrl = sshUrl;
    }

    public String getCloneUrl() {
        return cloneUrl;
    }

    public void setCloneUrl(String cloneUrl) {
        this.cloneUrl = cloneUrl;
    }

    public String getSvnUrl() {
        return svnUrl;
    }

    public void setSvnUrl(String svnUrl) {
        this.svnUrl = svnUrl;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getStargazersCount() {
        return stargazersCount;
    }

    public void setStargazersCount(int stargazersCount) {
        this.stargazersCount = stargazersCount;
    }

    public int getWatchersCount() {
        return watchersCount;
    }

    public void setWatchersCount(int watchersCount) {
        this.watchersCount = watchersCount;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isHasIssues() {
        return hasIssues;
    }

    public void setHasIssues(boolean hasIssues) {
        this.hasIssues = hasIssues;
    }

    public boolean isHasDownloads() {
        return hasDownloads;
    }

    public void setHasDownloads(boolean hasDownloads) {
        this.hasDownloads = hasDownloads;
    }

    public boolean isHasWiki() {
        return hasWiki;
    }

    public void setHasWiki(boolean hasWiki) {
        this.hasWiki = hasWiki;
    }

    public boolean isHasPages() {
        return hasPages;
    }

    public void setHasPages(boolean hasPages) {
        this.hasPages = hasPages;
    }

    public int getForksCount() {
        return forksCount;
    }

    public void setForksCount(int forksCount) {
        this.forksCount = forksCount;
    }

    public int getOpenIssuesCount() {
        return openIssuesCount;
    }

    public void setOpenIssuesCount(int openIssuesCount) {
        this.openIssuesCount = openIssuesCount;
    }

    public int getForks() {
        return forks;
    }

    public void setForks(int forks) {
        this.forks = forks;
    }

    public int getOpenIssues() {
        return openIssues;
    }

    public void setOpenIssues(int openIssues) {
        this.openIssues = openIssues;
    }

    public int getWatchers() {
        return watchers;
    }

    public void setWatchers(int watchers) {
        this.watchers = watchers;
    }

    public String getDefaultBranch() {
        return defaultBranch;
    }

    public void setDefaultBranch(String defaultBranch) {
        this.defaultBranch = defaultBranch;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Repository getRepository() {
        Repository repository = new Repository();
        repository.id = id;
        repository.name = name;
        repository.fullName = fullName;
        repository.privateX = privateX;
        repository.htmlUrl = htmlUrl;
        repository.description = description;
        repository.fork = fork;
        repository.url = url;
        repository.forksUrl = forksUrl;
        repository.keysUrl = keysUrl;
        repository.collaboratorsUrl = collaboratorsUrl;
        repository.teamsUrl = teamsUrl;
        repository.hooksUrl = hooksUrl;
        repository.issueEventsUrl = issueEventsUrl;
        repository.eventsUrl = eventsUrl;
        repository.assigneesUrl = assigneesUrl;
        repository.branchesUrl = branchesUrl;
        repository.tagsUrl = tagsUrl;
        repository.blobsUrl = blobsUrl;
        repository.gitTagsUrl = gitTagsUrl;
        repository.gitRefsUrl = gitRefsUrl;
        repository.treesUrl = treesUrl;
        repository.statusesUrl = statusesUrl;
        repository.languagesUrl = languagesUrl;
        repository.stargazersUrl = stargazersUrl;
        repository.contributorsUrl = contributorsUrl;
        repository.subscribersUrl = subscribersUrl;
        repository.subscriptionUrl = subscriptionUrl;
        repository.commitsUrl = commitsUrl;
        repository.gitCommitsUrl = gitCommitsUrl;
        repository.commentsUrl = commentsUrl;
        repository.issueCommentUrl = issueCommentUrl;
        repository.contentsUrl = contentsUrl;
        repository.compareUrl = compareUrl;
        repository.mergesUrl = mergesUrl;
        repository.archiveUrl = archiveUrl;
        repository.downloadsUrl = downloadsUrl;
        repository.issuesUrl = issuesUrl;
        repository.pullsUrl = pullsUrl;
        repository.milestonesUrl = milestonesUrl;
        repository.notificationsUrl = notificationsUrl;
        repository.labelsUrl = labelsUrl;
        repository.releasesUrl = releasesUrl;
        repository.deploymentsUrl = deploymentsUrl;
        repository.createdAt = createdAt;
        repository.updatedAt = updatedAt;
        repository.pushedAt = pushedAt;
        repository.gitUrl = gitUrl;
        repository.sshUrl = sshUrl;
        repository.cloneUrl = cloneUrl;
        repository.svnUrl = svnUrl;
        repository.size = size;
        repository.stargazersCount = stargazersCount;
        repository.watchersCount = watchersCount;
        repository.language = language;
        repository.hasIssues = hasIssues;
        repository.hasDownloads = hasDownloads;
        repository.hasWiki = hasWiki;
        repository.hasPages = hasPages;
        repository.forksCount = forksCount;
        repository.openIssuesCount = openIssuesCount;
        repository.forks = forks;
        repository.openIssues = openIssues;
        repository.watchers = watchers;
        repository.defaultBranch = defaultBranch;
        repository.score = score;

        return repository;
    }
}
