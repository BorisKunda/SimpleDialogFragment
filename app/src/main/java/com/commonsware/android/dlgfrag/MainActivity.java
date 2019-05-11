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

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;


/**VERY GOOD TUTORIAL
 * https://guides.codepath.com/android/using-dialogfragment
 */

public class MainActivity extends FragmentActivity {
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
  }

  public void showMe(View v) {
    new SampleDialogFragment().show(getSupportFragmentManager(), "sample");
  }


  @Override
  protected void onPause() {
    super.onPause();
    Log.e(MainActivity.class.getSimpleName(), "onPause: ");
  }

  @Override
  protected void onStop() {
    super.onStop();
    Log.e(MainActivity.class.getSimpleName(), "onStop: ");
  }
}
