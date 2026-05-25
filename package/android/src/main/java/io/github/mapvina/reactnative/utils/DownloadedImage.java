package io.github.mapvina.reactnative.utils;

import android.graphics.Bitmap;

public record DownloadedImage(String name, Bitmap bitmap, ImageEntry info) {
}
