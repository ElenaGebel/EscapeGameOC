package com.company.Controller.Strategy.Player;
import java.util.ArrayList;
import java.util.Random;

import com.company.Model.GameModel;

public class ArtificialIntelligence extends AbstactPlayer{

    protected ArrayList<CombinationElement> arrayForBinarySearch= new ArrayList<>();
    @Override
    public ArrayList<Integer> getCombination(Boolean newBinarySearch, String pattern) {
        if(newBinarySearch) {
            binarySearchCombinationWithPattern(pattern);
        }
            return combinationArrayList;
    }

    @Override
    public ArrayList<Integer> getSecretCombination() {
        if(secretCombinationArrayList.size() == 0)
            secretCombinationArrayList = generateCombination();

        return secretCombinationArrayList;
    }

    private void binarySearchCombinationWithPattern(String pattern) {

        if(!pattern.equals("") && pattern.length() ==  GameModel.getCombinationNum()
                    && checkSymbolString(pattern) && combinationArrayList != null
                    && combinationArrayList.size() ==  GameModel.getCombinationNum()
                    && arrayForBinarySearch != null){

            char[] patternArray = pattern.toCharArray();

            CombinationElement element;
            for (int i = 0; i < combinationArrayList.size(); i++){

                if(arrayForBinarySearch.get(i) != null){
                    element = binarySearch(arrayForBinarySearch.get(i), Character.toString(patternArray[i]));
                    arrayForBinarySearch.set(i, element);
                    combinationArrayList.set(i, element.proposition);
                }
            }
        } else{
            combinationArrayList = fillArrayForBinarySearch(0, 9);

        }
    }

 /*   private void generateCombinationWithPattern(String pattern) {

        if(!pattern.equals("") && pattern.length() ==  GameModel.getCombinationNum()
                && checkSymbolString(pattern) && combinationArrayList != null
                && combinationArrayList.size() ==  GameModel.getCombinationNum()){
            char[] patternArray = pattern.toCharArray();

            for (int i = 0; i < combinationArrayList.size(); i++){

                if(Character.toString(patternArray[i]).equals("-")  && combinationArrayList.get(i) > 0){
                     combinationArrayList.set(i, new Random().nextInt(combinationArrayList.get(i)));

                }else if (Character.toString(patternArray[i]).equals("+") && combinationArrayList.get(i) < 9){

                    combinationArrayList.set(i, new Random().nextInt(10 - combinationArrayList.get(i)) + combinationArrayList.get(i));
                }
             }

        } else{
            combinationArrayList = generateCombination();

        }
    }*/

    private ArrayList<Integer> fillArrayForBinarySearch(int min, int max) {
        arrayForBinarySearch = new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        CombinationElement element;
        for (int i = 0; i < GameModel.getCombinationNum(); i++){
            element = new CombinationElement(min, max);
            arrayForBinarySearch.add(new CombinationElement(min, max));
            arrayList.add(Integer.valueOf(element.proposition));
        }
        return arrayList;
    }

    private ArrayList<Integer> generateCombination() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < GameModel.getCombinationNum(); i++)
            arrayList.add(new Random().nextInt(10));
        return arrayList;
    }

    private CombinationElement binarySearch(CombinationElement element,  String pattern) {
        if(pattern.equals("-")){
            if(element.proposition > element.getMin())
                element.setMax(element.proposition - 1);
            else
                element.setMax(element.proposition);
        }

        if(pattern.equals("+")){
            if(element.proposition < element.getMax())
                element.setMin(element.proposition + 1);
            else
                element.setMin(element.proposition);
        }
        element.countProposition();
        System.out.println("element: "+element.toString());
        return element;

    }


}
