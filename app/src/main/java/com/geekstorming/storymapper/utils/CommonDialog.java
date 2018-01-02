package com.geekstorming.storymapper.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.ui.books.contracts.ListBookContract;
import com.geekstorming.storymapper.ui.books.fragments.BookList_Fragment;
import com.geekstorming.storymapper.ui.books.presenter.ListBookPresenter;

/**
 * Created by napst on 02/01/2018.
 */

public class CommonDialog {

    public static final String MSG = "msg";
    public static final String TITLE = "title";

    public static Dialog showDeleteBookDialog (final Bundle b, Context context, final ListBookContract.Presenter presenter) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder
                .setMessage(b.getString(MSG))
                .setTitle(b.getString(TITLE))
                .setPositiveButton(R.string.btn_dialog_confirm, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        presenter.removeBook((Book) b.getParcelable(Book.TAG));
                    }
                })
                .setNegativeButton(R.string.btn_dialog_cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        return builder.create();
    }
}
