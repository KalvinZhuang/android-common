package com.fleetlabs.library.upload;

/**
 * Created by Aaron.Wu on 2016/1/19.
 */
public abstract class UploadCallback {
    public abstract void onSuccess();
    public abstract void onFailure(Exception exc);

    public void onProgress(long currentSize, long totalSize) {
    }
}
