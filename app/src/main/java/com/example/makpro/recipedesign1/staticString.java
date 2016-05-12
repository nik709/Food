package com.example.makpro.recipedesign1;

import java.util.ArrayList;

/**
 * Created by Никита on 16.04.2016.
 */
public class staticString {
    public static ArrayList<String> str;
    public static String RecipeName;
    public static int quantityRecipe ;
    public static  String Products;

    public static ArrayList<String> NameRecipe;
    public static ArrayList<String> NameCuisine;
    public static ArrayList<String> NameCategory;
    public static ArrayList<String> NameMethod;
    public static ArrayList<String> NameTime;
    public static ArrayList<String> Description;
    public static ArrayList<String> Caloric;
    public static String addComment;

    public static ArrayList<String> SearchCuisine;
    public static ArrayList<String> SearchCategory;
    public static ArrayList<String> SearchCookingMethod;
    public static ArrayList<String> SearchTime;

    public static int IDofRecipe=0;

    public static boolean IsAdd = false;
    public static ArrayList<String> addIngridients; //НОВЫЕ ИНГРИДИЕНТЫ
    public static ArrayList<String> addTime; //НОВОЕ ВРЕМЯ
    public static ArrayList<String> addCuisine; //НОВАЯ КУХНЯ
    public static ArrayList<String> addCategory; //НОВАЯ КАТЕГОРИЯ
    public static ArrayList<String> addCookingMethod; //НОВЫЙ СПОСОБ ПРИГОТОВЛЕНИЯ
    public static String addName; //НОВОЕ ИМЯ
    public static String addDescription; //НОВОЕ ОПИСАНИЕ
    public static String addCaloricContent; //НОВЫЕ КАЛОРИИ
}
