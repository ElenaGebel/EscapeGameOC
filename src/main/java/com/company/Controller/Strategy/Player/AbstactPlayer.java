package com.company.Controller.Strategy.Player;

import java.util.ArrayList;
/**
 * Classe Abstact classe mère pour User et ArtificialIntelligence
 */
public abstract class AbstactPlayer {

    protected ArrayList<Integer> combinationArrayList = new ArrayList<>();
    protected ArrayList<Integer> secretCombinationArrayList = new ArrayList<>();

    public AbstactPlayer() {
    }

    /**
     * Retourne la combinaison
     * @param generateNewCombitation paramètre pour savoir si il faut retourner une nouvelle combinaison
     * @param pattern paramètre pour comparer la réponse de l'utilisateur et la combinaison précédente
     * @return la combinaison
     */
    public ArrayList<Integer> getCombination(Boolean generateNewCombitation, String pattern){
        return combinationArrayList;
    }

    /**
     * Retourne la combinaison secrète
     * @return la combinaison secrète
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
     * Demande à comparer la proposition de l’ordinateur et la combinaison secrète
     * @param compareAnswer paramètre pour comparer la réponse de l'utilisateur et la combinaison secrète
     * @return reponse
     */

    public String askToCompare(String compareAnswer)  {
        return compareAnswer;
    }

    /**
     * Sert à convertir un tableau de chiffres de la combinaison a une chaîne de caractères
     * @return une chaîne de caractères
     */
    public String getCombinationToString(){
        return combinationArrayList.toString().replaceAll("\\[|\\]|[,][ ]","");
    }

    /**
     * Sert à convertir un tableau de chiffres de la combinaison secrète a une chaîne de caractères
     * @return une chaîne de caractères
     */
    public String getSecretCombinationToString(){
        return secretCombinationArrayList.toString().replaceAll("\\[|\\]|[,][ ]","");
    }

    /**
     * Vérifie si une chaîne de caractères contient que les chiffres
     * @param string une chaîne de caractères
     * @return result boolean
     */
    protected boolean checkNumberString(String string) {
        if (string == null) return false;
        return string.matches("^\\d+$");
    }

    /**
     * Vérifie si une chaîne de caractères contient que les caractères "+", "=", "-"
     * @param string une chaîne de caractères
     * @return result boolean
     */
    protected boolean checkSymbolString(String string) {
        if (string == null) return false;
        return string.matches("^[-+=]+$");
    }

}
