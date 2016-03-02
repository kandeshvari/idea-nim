package org.dmitrigb.ideanim;

import com.intellij.lang.Language;

public class NimLanguage extends Language {
    public static NimLanguage INSTANCE = new NimLanguage();

    public NimLanguage() {
        super("Nim");
    }
}
