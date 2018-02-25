package com.geekstorming.storymapper.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.data.pojo.Book;
import com.geekstorming.storymapper.data.pojo.Character;
import com.geekstorming.storymapper.ui.books.contracts.ListBookContract;
import com.geekstorming.storymapper.ui.books.fragments.BookList_Fragment;
import com.geekstorming.storymapper.ui.books.presenter.ListBookPresenter;
import com.geekstorming.storymapper.ui.characters.contracts.ListCharacterContract;
import com.geekstorming.storymapper.ui.characters.presenter.CharaterListPresenter;

/**
 * Common UI utils for multiple purposes
 */

public class CommonUIUtils {

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

    public static Dialog showDeleteCharacterDialog (final Bundle b, Context context, final ListCharacterContract.Presenter presenter) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder
                .setMessage(b.getString(MSG))
                .setTitle(b.getString(TITLE))
                .setPositiveButton(R.string.btn_dialog_confirm, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        presenter.removeCharacter((Character) b.getParcelable(Character.TAG));
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

    public static ProgressDialog makeProgressDialog(Context context, String message) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(message);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        return progressDialog;
    }

    public static Dialog showHelpDialog (Context context) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder
                .setMessage("Si tiene dudas, puede contactar con el equipo de desarrollo en elena.guzbla@gmail.com")
                .setTitle("¿Necesita ayuda?")
                .setNegativeButton(R.string.btn_dialog_roger, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        return builder.create();
    }
}
