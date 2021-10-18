package com.ntuc.socialenterprises.qa.configmanager;

public class ReaderManager {

    private static ReaderManager readerManager = new ReaderManager();
    private static GUIConfigReader guiConfigReader;
    private static CommonConfigReader commonConfigReader;

    private ReaderManager() { }

    public static ReaderManager getInstance( ) {
        return readerManager;
    }
    public GUIConfigReader getGUIConfigReader() { return (guiConfigReader == null) ? new GUIConfigReader() : guiConfigReader; }
    public CommonConfigReader getCommonConfigReader() { return (commonConfigReader == null) ? new CommonConfigReader() : commonConfigReader; }

}
