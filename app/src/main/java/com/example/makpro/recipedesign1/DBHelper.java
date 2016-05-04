package com.example.makpro.recipedesign1;

/**
 * Created by Давлат on 17.04.2016.
 */
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Давлат on 16.04.2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    //для работы с ресурсами
    private final Context fContext;
    ContentValues contentValues;
    Resources res;

    public DBHelper(Context context) {
        super(context, "CookDB", null, 1);
        fContext = context;
    }

    public void onCreate(SQLiteDatabase db) {

        contentValues = new ContentValues();
        res = fContext.getResources();

        //СОЗДАНИЕ ТАБЛИЦ БАЗЫ ДАННЫХ----------------------------------------------------------

        //создаем таблицу !РЕЦЕПТЫ!---------------
        db.execSQL("create table Recipe ("
                +"Recipe_ID integer primary key,"
                +"Rec_Cuisine_ID integer,"
                +"Rec_Category_ID integer,"
                +"Rec_Cooking_method_ID integer,"
                +"Rec_Time_ID integer,"
                +"Description_cooking_method text,"
                +"Recipe_name text,"
                +"Caloric_content text"
                + ");");

        //создаем таблицу !КУХНЯ!------------------
        db.execSQL("create table Cuisine("
                + "Cuisine_ID integer primary key,"
                + "Cuisine_name text" + ");");


        //создаем таблицу !ВИД БЛЮДА!---------------
        db.execSQL("create table Category("
                + "Category_ID integer primary key,"
                + "Category_name text" + ");");

        //создаем таблицу !СПОСОБ ПРИГТОВЛЕНИЯ!-----------
        db.execSQL("create table Cooking_method ("
                + "Cooking_method_ID integer primary key,"
                + "Method_name text" + ");");

        //создаем таблицу !СОСТАВ БЛЮДА!--------
        db.execSQL("create table Composition ("
                + "Comp_ID integer primary key,"
                + "Comp_Ingredient_ID integer,"
                + "Comp_recipe_ID integer"
                + ");");

        //создаем таблицу !ВРЕМЯ!---------------
        db.execSQL("create table Time ("
                +"Time_ID integer primary key,"
                +"Time_name text" + ");");


        //создаем таблицу !ЕДИНИЦЫ ИЗМЕРЕНИЯ!----------
        db.execSQL("create table Unit_measure ("
                +"Unit_measure_ID integer primary key,"
                +"Unit_measure_name text" + ");");

        //создаем таблицу !ИНГРЕДИЕНТ!---------------
        db.execSQL("create table Ingredient ("
                +"Ingredient_ID integer primary key,"
                +"Ingredient_name text" + ");");

        //создаем таблицу !ОТЗЫВ!-------------------
        db.execSQL("create table Reference ("
                +"Reference_ID integer primary key,"
                +"Ref_Recipe_ID integer,"
                +"Message text,"
                +"Date datetime" + ");");

        //ЗАПОЛНЕНИЕ ТАБЛИЦ ИЗ РЕСУРСОВ------------------------------------------------------------

        //заполнение таблицы !КУХНЯ!

        String[] cuisine_name = res.getStringArray(R.array.Cuisine_name);
        int[] cuisine_id = res.getIntArray(R.array.Cuisine_id);

        for (int i=0; i<cuisine_id.length;i++){
            contentValues.clear();
            contentValues.put("Cuisine_ID",cuisine_id[i]);
            contentValues.put("Cuisine_name",cuisine_name[i]);
            db.insert("Cuisine",null,contentValues);
        }

        //заполнение таблицы !ВИД БЛЮДА!

        String[] category_name = res.getStringArray(R.array.Category_name);
        int[] category_id = res.getIntArray(R.array.Category_id);

        for (int i=0; i<category_id.length;i++){
            contentValues.clear();
            contentValues.put("Category_ID",category_id[i]);
            contentValues.put("Category_name",category_name[i]);
            db.insert("Category",null,contentValues);
        }

        //заполнение таблицы !СПОСОБ ПРИГТОВЛЕНИ!

        String[] method_name = res.getStringArray(R.array.Method_name);
        int[]  cooking_method_id = res.getIntArray(R.array.Cooking_method_ID);

        for (int i=0; i<cooking_method_id.length;i++){
            contentValues.clear();
            contentValues.put("Cooking_method_ID",cooking_method_id[i]);
            contentValues.put("Method_name",method_name[i]);
            db.insert("Cooking_method",null,contentValues);
        }

        //заполнение таблицы !ВРЕМЯ!

        String[] time_name = res.getStringArray(R.array.Time_name);
        int[]  time_id = res.getIntArray(R.array.Time_ID);

        for (int i=0; i<time_id.length;i++){
            contentValues.clear();
            contentValues.put("Time_ID",time_id[i]);
            contentValues.put("Time_name",time_name[i]);
            db.insert("Time",null,contentValues);
        }

        //заполнение таблицы !ЕДИНИЦЫ ИЗМЕРЕНИЯ!

        String[] unit_measure_name= res.getStringArray(R.array.Unit_measure_name);
        int[]  unit_measure_id = res.getIntArray(R.array.Unit_measure_ID);

        for (int i=0; i<unit_measure_id.length;i++){
            contentValues.clear();
            contentValues.put("Unit_measure_ID",unit_measure_id[i]);
            contentValues.put("Unit_measure_name",unit_measure_name[i]);
            db.insert("Unit_measure",null,contentValues);
        }

        //заполняем таблицу ингредиентов

        String[] ingredient_name= res.getStringArray(R.array.Ingredient_name);
        int[]  ingredient_id = res.getIntArray(R.array.Ingredient_id);

        for (int i=0; i<ingredient_id.length;i++){
            contentValues.clear();
            contentValues.put("Ingredient_ID",ingredient_id[i]);
            contentValues.put("Ingredient_name",ingredient_name[i]);
            db.insert("Ingredient",null,contentValues);
        }
//----------------------------------------ВЕЛИКИЙ И МОГУЧИЙ ПРИМЕР--------------------------------
        contentValues.clear();
        contentValues.put("Recipe_ID",1);
        contentValues.put("Rec_Cuisine_ID",2);
        contentValues.put("Rec_Category_ID",11);
        contentValues.put("Rec_Cooking_method_ID",16);
        contentValues.put("Rec_Time_ID",1002);
        contentValues.put("Description_cooking_method","Крутое блюдо готовиться только так");
        contentValues.put("Recipe_name","Крутое блюдо");
        contentValues.put("Caloric_content","150ккал");
        db.insert("Recipe",null,contentValues);


        contentValues.clear();
        contentValues.put("Comp_ID",1);
        contentValues.put("Comp_recipe_ID",1);
        contentValues.put("Comp_Ingredient_ID",110);
        db.insert("Composition",null,contentValues);

        contentValues.clear();
        contentValues.put("Comp_ID",2);
        contentValues.put("Comp_recipe_ID",1);
        contentValues.put("Comp_Ingredient_ID",133);
        db.insert("Composition",null,contentValues);

        contentValues.clear();
        contentValues.put("Comp_ID",3);
        contentValues.put("Comp_recipe_ID",1);
        contentValues.put("Comp_Ingredient_ID",107);
        db.insert("Composition",null,contentValues);




    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
