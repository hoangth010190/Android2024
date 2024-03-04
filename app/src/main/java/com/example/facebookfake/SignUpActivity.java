package com.example.facebookfake;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.facebookfake.classes.Utils;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.IOException;

public class SignUpActivity extends AppCompatActivity {
    ImageView imgAvatar;
    RelativeLayout relativeLayout;
    EditText edUsername, edFullName, edPass, edConfirmPass;
    Button btSignUp, btForgotPass;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initView();
        initAction();
    }

    void initView() {
        relativeLayout = findViewById(R.id.relativeLayout);
        imgAvatar = findViewById(R.id.imageViewAvatar);
        imgAvatar.setImageBitmap(Utils.loadBitmapFromAssets(this, "select_avatar_placeholder.png"));
        //
        toolbar = findViewById(R.id.materialToolbarSignUp);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    void initAction() {
        imgAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayBottomSheet();
            }
        });
    }

    void checkInput() {

    }

    private void displayBottomSheet() {

        // creating a variable for our bottom sheet dialog.
        final BottomSheetDialog bottomSheetTeachersDialog = new BottomSheetDialog(this, R.style.BottomSheetDialogTheme);

        // passing a layout file for our bottom sheet dialog.
        View layout = LayoutInflater.from(this).inflate(R.layout.select_photo_bottom_sheet_layout, relativeLayout, false);

        // passing our layout file to our bottom sheet dialog.
        bottomSheetTeachersDialog.setContentView(layout);

        // below line is to set our bottom sheet dialog as cancelable.
        bottomSheetTeachersDialog.setCancelable(false);

        // below line is to set our bottom sheet cancelable.
        bottomSheetTeachersDialog.setCanceledOnTouchOutside(true);
        bottomSheetTeachersDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                BottomSheetDialog d = (BottomSheetDialog) dialogInterface;

                FrameLayout bottomSheet = (FrameLayout) d.findViewById(com.google.android.material.R.id.design_bottom_sheet);
                BottomSheetBehavior.from(bottomSheet).setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });

        // below line is to display our bottom sheet dialog.
        bottomSheetTeachersDialog.show();

        // initializing our text views and image views.
        Button btGallery = layout.findViewById(R.id.buttonSelectGallery);
        btGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                imagePickerActivityResult.launch(photoPickerIntent);
            }
        });
        Button btCapture = layout.findViewById(R.id.buttonSelectCapture);
        btCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                imageCaptureActivityResult.launch(intent);
            }
        });
        // creating a variable for document reference.

    }

    ActivityResultLauncher<Intent> imagePickerActivityResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result != null) {
                        Intent data = result.getData();
                        Uri imageUri = data.getData();
                        Bitmap bitmap = null;
                        try {
                            bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                            imgAvatar.setImageBitmap(bitmap);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
    );

    ActivityResultLauncher<Intent> imageCaptureActivityResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result != null) {
                        Intent intent = result.getData();
                        Bitmap photo = (Bitmap) intent.getExtras().get("data");
                        imgAvatar.setImageBitmap(photo);
                    }
                }
            }
    );

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}