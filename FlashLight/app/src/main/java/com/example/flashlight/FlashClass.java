package com.example.flashlight;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;

public class FlashClass {
    private boolean flash_status = false;
    private Context context;

    public FlashClass(Context context){
        this.context = context;
    }

    public void flashOn(){
        CameraManager cameraManager = (CameraManager) context.getSystemService(Context.CAMERA_SERVICE);
        try {
            assert cameraManager != null;
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, true);
            flash_status = true;
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

    }

    public void flashOff(){
        CameraManager cameraManager = (CameraManager) context.getSystemService(Context.CAMERA_SERVICE);
        try {
            assert cameraManager != null;
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, false);
            flash_status = false;
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

    }

    public boolean isFlash_status() {
        return flash_status;
    }

}
