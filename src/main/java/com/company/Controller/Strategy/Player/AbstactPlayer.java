package com.company.Controller.Strategy.Player;

import java.util.ArrayList;
/**
 * Classe Abstact classe mere pour User et ArtificialIntelligence
 */
public abstract class AbstactPlayer {

    protected ArrayList<Integer> combinationArrayList = new ArrayList<>();
    protected ArrayList<Integer> secretCombinationArrayList = new ArrayList<>();

    public AbstactPlayer() {
    }

    /**
     * Retourne la combinaison
     * @param generateNewCombitation parametre pour savoir si il faut retourner une nouvelle combinaison
     * @param pattern parametre pour comparer la reponse de l utilisateur et la combinaison precedente
     * @return la combinaison
     */
    public ArrayList<Integer> getCombination(Boolean generateNewCombitation, String pattern){
        return combinationArrayList;
    }

    /**
     * Retourne la combinaison secrete
     * @return la combinaison secrete
     */
    public ArrayList<Integer>  getSecretCombination(){
        return secretCombinationArrayList;
    }

    /**
     * Compare 2 tableau
     * @param arrayList1
     * @param arrayList2
     * @return result
     */
    public String compare(ArrayList<Integer> arrayList1, ArrayList<Integer> arrayList2) {
        String result = "";

        if(arrayList1.size() == arrayList2.size()){
            for (int i = 0; i < arrayList1.size(); i++) {
                if (arrayList1.get(i).compareTo(arrayList2.get(i)) == 0)
                    result +="=";
                else if (arrayList1.get(i).compareTo(arrayList2.get(i)) == 1)
                    result +="+";
                else if (arrayList1.get(i).compareTo(arrayList2.get(i)) == -1)
                    result +="-";
            }
        }
        return result;
    }

    /**
     * Demande a comparer la proposition de l ordinateur et la combinaison secrete
     * @param compareAnswer parametre pour comparer la reponse de l utilisateur et la combinaison secrete
     * @return reponse
     */

    public String askToCompare(String compareAnswer)  {
        return compareAnswer;
    }

    /**
     * Sert a convertir un tableau de chiffres de la combinaison a une chaine de caracteres
     * @return une chaine de caracteres
     */
    public String getCombinationToString(){
        return combinationArrayList.toString().replaceAll("\\[|\\]|[,][ ]","");
    }

    /**
     * Sert a convertir un tableau de chiffres de la combinaison secrete a une chaine de caracteres
     * @return une chaine de caracteres
     */
    public String getSecretCombinationToString(){
        return secretCombinationArrayList.toString().replaceAll("\\[|\\]|[,][ ]","");
    }

    /**
     * Verifie si une chaine de caracteres contient que les chiffres
     * @param string une chaine de caracteres
     * @return result boolean
     */
    protected boolean checkNumberString(String string) {
        if (string == null) return false;
        return string.matches("^\\d+$");
    }

    /**
     * Verifie si une chaine de caracteres contient que les caracteres "+", "=", "-"
     * @param string une chaine de caracteres
     * @return result boolean
     */
    protected boolean checkSymbolString(String string) {
        if (string == null) return false;
        return string.matches("^[-+=]+$");
    }

}
