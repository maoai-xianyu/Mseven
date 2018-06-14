package com.mao.cn.mseven.utils.tools;

import com.mao.cn.mseven.MsevenApplication;

import java.io.File;

public class PathU {
    private static PathU instance = null;
    private File assetsFile;
    private File testVideoPath;
    private File files;
    private File blurPath;
    private static String filePath;
    private File resourcePath;

    public File getTestVideoPath() {
        return testVideoPath;
    }

    public void setTestVideoPath(File testVideoPath) {
        this.testVideoPath = testVideoPath;
    }


    public static String getFilePath() {
        return filePath;
    }

    public static void setFilePath(String filePath) {
        PathU.filePath = filePath;
    }


    public File getFiles() {
        return files;
    }

    public String getFilesPath() {
        return files.getPath();
    }

    public File getBlurPath() {
        return blurPath;
    }


    public File getResourceFile() {
        return resourcePath;
    }

    public String getResourcePath() {
        return resourcePath.getPath();
    }


    private PathU() {
    }

    public static PathU getInstance() {
        if (instance == null) {
            instance = new PathU();
        }
        return instance;
    }

    public void initDirs() {
        files = PathUtils.getInstance().generatePath("", "files", MsevenApplication.context());
        blurPath = PathUtils.getInstance().generatePath("", "blur", MsevenApplication.context());
        resourcePath = PathUtils.getInstance().generatePath("", "resource", MsevenApplication.context());
        assetsFile = PathUtils.getInstance().generatePath("", "files/files", MsevenApplication.context());
    }

    public File getAssetsFile() {
        return assetsFile;
    }

    public static String filePath() {
        if (StringU.isEmpty(filePath)) {
            filePath = PathU.getInstance().getAssetsFile().getPath();
        }
        return filePath;
    }

}
