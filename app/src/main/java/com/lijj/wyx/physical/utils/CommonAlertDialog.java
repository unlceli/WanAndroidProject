package com.lijj.wyx.physical.utils;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.lijj.wyx.physical.R;


public class CommonAlertDialog {
    private AlertDialog alertDialog;

    public static CommonAlertDialog newInstance() {
        return CommonAlertDialogHolder.COMMON_ALERT_DIALOG;
    }

    private static class CommonAlertDialogHolder {
        private static final CommonAlertDialog COMMON_ALERT_DIALOG = new CommonAlertDialog();
    }

    /**
     * Cancel alertDialog
     *
     * @param isadd
     */
    public void cancelDialog(boolean isadd) {
        if (isadd && alertDialog != null && alertDialog.isShowing()) {
            alertDialog.dismiss();
            alertDialog = null;
        }
    }

    /**
     * @param mActivity
     * @param content
     * @param btnContent
     */
    public void showDialog(Activity mActivity, String content, String btnContent) {
        if (mActivity == null) {
            return;
        }
        if (alertDialog == null) {
            alertDialog = new AlertDialog.Builder(mActivity, R.style.myCorDialog).create();
        }
        alertDialog.setCanceledOnTouchOutside(false);
        Window window = alertDialog.getWindow();
        if (window != null) {
            window.setContentView(R.layout.common_alert_dialog);
            TextView contentTv = window.findViewById(R.id.dialog_content);
            contentTv.setText(content);
            Button mOkBtn = window.findViewById(R.id.dialog_btn);
            mOkBtn.setText(btnContent);
            mOkBtn.setOnClickListener(view -> {
                if (alertDialog != null) {
                    alertDialog.cancel();
                    alertDialog = null;
                }
            });

            View btnDivider = window.findViewById(R.id.dialog_btn_divider);
            btnDivider.setVisibility(View.GONE);
            Button mNeBtn = window.findViewById(R.id.dialog_negative_btn);
            mNeBtn.setVisibility(View.GONE);
        }
    }

    /**
     * @param mActivity
     * @param content
     * @param btnContent
     * @param neContent
     * @param onPoClickListener
     * @param onNeClickListener
     */

    public void showDialog(Activity mActivity, String content, String btnContent, String neContent,
                           final View.OnClickListener onPoClickListener,
                           final View.OnClickListener onNeClickListener) {
        if (mActivity == null) {
            return;
        }
        if (alertDialog == null) {
            alertDialog = new AlertDialog.Builder(mActivity, R.style.myCorDialog).create();

        }
        if (!alertDialog.isShowing()) {
            alertDialog.show();
        }
        Window window = alertDialog.getWindow();
        if (window != null) {
            window.setContentView(R.layout.common_alert_dialog);
            TextView contentTv = window.findViewById(R.id.dialog_content);
            contentTv.setText(content);
            Button mOkBtn = window.findViewById(R.id.dialog_btn);
            mOkBtn.setText(btnContent);
            mOkBtn.setOnClickListener(onPoClickListener);
            Button btnDivider = window.findViewById(R.id.dialog_negative_btn);
            btnDivider.setVisibility(View.VISIBLE);
            Button mNeBtn = window.findViewById(R.id.dialog_negative_btn);
            mNeBtn.setText(neContent);
            mNeBtn.setVisibility(View.VISIBLE);
            mNeBtn.setOnClickListener(onNeClickListener);

        }
    }

}
