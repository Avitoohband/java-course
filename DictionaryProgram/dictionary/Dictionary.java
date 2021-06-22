package dictionary;

import java.util.*;

public class Dictionary {

    private Map<String, String> dictionary;
    public Dictionary(){
        dictionary  = new TreeMap<String,String>();
    }
    public void printAllEntrySorted() {
        if (dictionary.isEmpty())
        {
            System.out.println("Nothing to show");
            return;
        }
        System.out.println(dictionary);
    }
    public void addToDictionary(String key, String val){
        try {
            checkValidValues(key, val);
            checkAddingExistingItem(key);
        }catch (DictionaryException e){
            e.printStackTrace();
            return;
        }
        dictionary.put(key, val);
        System.out.println(key + " has been successfully added to the Dictionary with the value: " + val);
    }
    public void edit(String key, String val){
        try {
            checkValidValues(key, val);
            checkEditingNonExistingElement(key);
        }catch (DictionaryException e){
            e.printStackTrace();
            return;
        }
        dictionary.put(key, val);
        System.out.println(key + "has been successfully updated with the value: "  + val);
    }
    public void removeKey(String key){
        try{
            checkValidValues(key, "holder");
            checkEditingNonExistingElement(key);
        }catch (DictionaryException e){
            e.printStackTrace();
            return;
        }
        dictionary.remove(key);
       System.out.println(key + " has been successfully remove from the Dictionary");
    }
    private void checkValidValues(String key, String val) throws DictionaryException{
        if (key == null || val == null || key.length() == 0 || val.length() == 0){
            throw new DictionaryException("Illegal input, an empty String or a null value");
        }
    }
    private void checkAddingExistingItem(String key) throws DictionaryException{
        if(dictionary.containsKey(key)){
            throw new DictionaryException("Key: (" + key +") is already exist in the Dictionary");
        }
    }
    private void checkEditingNonExistingElement(String key) throws DictionaryException{
        if(!dictionary.containsKey(key)){
            throw new DictionaryException("Key: (" + key +") does not exist in the Dictionay");
        }
    }
    public void printKeys(){
        System.out.println(dictionary.keySet());
    }
}
