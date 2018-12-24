/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demonfolder.preferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Maxime
 */
public class Preferences {

    public static List<String> EXTENSION_LIST = new ArrayList<String>();
    public static String ROOT_PATH = "";
    public static String MUSIC_PATH = ROOT_PATH + "\\Music";
    public static String DOCUMENT_PATH = ROOT_PATH + "\\Document";
    public static String VIDEO_PATH = ROOT_PATH + "\\Video";
    public static String PICTURE_PATH = ROOT_PATH + "\\Picture";

    public static List<String> MusicExtensionList = Arrays.asList("mp3", "wav", "wma");
    public static List<String> DocumentExtensionList = Arrays.asList("doc", "docx", "xls", "xlsx");
    public static List<String> VideoExtensionList = Arrays.asList("mp4");
    public static List<String> PictureExtensionList = Arrays.asList("jpeg", "png", "jpg");

    public static List<List<String>> allExtensionList = Arrays.asList(MusicExtensionList, DocumentExtensionList,
            VideoExtensionList, PictureExtensionList);

}
