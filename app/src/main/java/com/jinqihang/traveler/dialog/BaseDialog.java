package com.jinqihang.traveler.dialog;

import android.app.Dialog;
import android.content.Context;

/**
 * 对话框基类
 * Created by huangzj on 2015/10/25.
 * Created by Administrator on 2017/10/16 0016.
 */

public abstract class BaseDialog {
    protected Context context;
    protected Dialog dialog;

    public boolean isShow() {
        if (dialog != null) {
            return dialog.isShowing();
        }
        return false;
    }

    public void show() {
        if (dialog == null || dialog.isShowing()) {
            return;
        }
        dialog.show();
    }

    public void dismiss() {
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        dialog.dismiss();
    }
}
