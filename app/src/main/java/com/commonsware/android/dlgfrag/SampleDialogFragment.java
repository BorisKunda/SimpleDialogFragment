/***
  Copyright (c) 2012 CommonsWare, LLC
  Licensed under the Apache License, Version 2.0 (the "License"); you may not
  use this file except in compliance with the License. You may obtain a copy
  of the License at http://www.apache.org/licenses/LICENSE-2.0. Unless required
  by applicable law or agreed to in writing, software distributed under the
  License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
  OF ANY KIND, either express or implied. See the License for the specific
  language governing permissions and limitations under the License.
  
  Covered in detail in the book _The Busy Coder's Guide to Android Development_
    https://commonsware.com/Android
 */

package com.commonsware.android.dlgfrag;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class SampleDialogFragment extends DialogFragment implements
    DialogInterface.OnClickListener {
  private View form=null;

  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    Log.e(SampleDialogFragment.class.getSimpleName(), "onCreateDialog: ");

    form=
        getActivity().getLayoutInflater()
                     .inflate(R.layout.dialog, null);

    AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

    return(builder.setTitle(R.string.dlg_title).setView(form)
                  .setPositiveButton(android.R.string.ok, this)
                  .setNegativeButton(android.R.string.cancel, null).create());
  }




  @Override
  public void onClick(DialogInterface dialog, int which) {
    String template=getActivity().getString(R.string.toast);
    EditText name=(EditText)form.findViewById(R.id.title);
    EditText value=(EditText)form.findViewById(R.id.value);
    String msg=
        String.format(template, name.getText().toString(),
                      value.getText().toString());

    Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
  }
  
  @Override
  public void onDismiss(DialogInterface unused) {//pressed cancel + called onConfigurationChange
    super.onDismiss(unused);
    
    Log.d(getClass().getSimpleName(), "Goodbye!");
  }
  
  @Override
  public void onCancel(DialogInterface unused) {//pressed back or empty space pressed
    super.onCancel(unused);
    
    Toast.makeText(getActivity(), R.string.back, Toast.LENGTH_LONG).show();
  }


  /**lifecycle methods */

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    Log.e(SampleDialogFragment.class.getSimpleName(), "onAttach: ");


  }

  /**Use onCreateView when the entire view of the dialog is going to be defined via custom XML.*/
  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    Log.e(SampleDialogFragment.class.getSimpleName(), "onCreateView: ");

    return super.onCreateView(inflater, container, savedInstanceState);

  }

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    Log.e(SampleDialogFragment.class.getSimpleName(), "onActivityCreated: ");

  }

  @Override
  public void onStart() {
    super.onStart();
    Log.e(SampleDialogFragment.class.getSimpleName(), "onStart: ");
  }

  @Override
  public void onResume() {
    super.onResume();
    Log.e(SampleDialogFragment.class.getSimpleName(), "onResume: ");
  }


  @Override
  public void onPause() {
    super.onPause();
    Log.e(SampleDialogFragment.class.getSimpleName(), "onPause: ");
  }

  @Override
  public void onStop() {
    super.onStop();
    Log.e(SampleDialogFragment.class.getSimpleName(), "onStop: ");
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    Log.e(SampleDialogFragment.class.getSimpleName(), "onDestroyView: ");
  }


  @Override
  public void onDestroy() {
    super.onDestroy();
    Log.e(SampleDialogFragment.class.getSimpleName(), "onDestroy: ");
  }

  @Override
  public void onDetach() {
    super.onDetach();
    Log.e(SampleDialogFragment.class.getSimpleName(), "onDetach: ");
  }
}
