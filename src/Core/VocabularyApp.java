package Core;

import java.io.IOException;
import java.util.*;

public class VocabularyApp{
    public static DictionaryKeep dictionary;
    
    public static void start(){
        dictionary = FileKeep.readKeep();
        if(dictionary==null){
            dictionary = new DictionaryKeep();
        }
    }
    
    public static DictionaryKeep getDictionary() {
        return dictionary;
    }
    
}