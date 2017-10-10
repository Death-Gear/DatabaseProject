package com.example.shakkhor.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by shakkhor on 7/23/17.
 */

public class MakeDatabase  extends SQLiteOpenHelper {


    SQLiteDatabase db;
    public static final String Database_Name = "Medicine.db";
    private static final int Database_Version = 1;

    public static final String Table1  = "User";
    public static final String T1_Col1 = "User_ID";
    public static final String T1_Col2 = "User_Name";
    public static final String T1_Col3 = "User_Email";
    public static final String T1_Col4 = "User_Password";


    public static final String Table2  = "Drugs";
    public static final String T2_Col1 = "Drug_ID";
    public static final String T2_Col2 = "Drug_Name";
    public static final String T2_Col3 = "Drug_Genre";
    public static final String T2_Col4 = "Drug_Form";
    public static final String T2_Col5 = "Drug_Strength";
    public static final String T2_Col6 = "Drug_Company";
    public static final String T2_Col7 = "Drug_Indication";
    public static final String T2_Col8 = "Drug_Class";


    public static final String Table3  = "Class";
    public static final String T3_Col1 = "Class_ID";
    public static final String T3_Col2 = "Class_Name";


    public static final String Table4  = "Company";
    public static final String T4_Col1 = "Company_ID";
    public static final String T4_Col2 = "Company_Name";
    public static final String T4_Col3 = "Company_Class";
    public static final String T4_Col4 = "Company_Genre";
    public static final String T4_Col5 = "Company_Indication";

    public static final String Table5  = "Genre";
    public static final String T5_Col1 = "Genre_ID";
    public static final String T5_Col2 = "Genre_Name";

    public static final String Table6  = "Favorite";
    public static final String T6_Col1 = "User_ID";
    public static final String T6_Col2 = "Drug_ID";

    public static final String Table7  = "Indication";
    public static final String T7_Col1 = "Indication_ID";
    public static final String T7_Col2 = "Indication_Name";




    public MakeDatabase(Context context ) {
        super(context, Database_Name, null, Database_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " +Table1 + " (User_ID INTEGER PRIMARY KEY, User_Name TEXT, User_Email TEXT, User_Password TEXT)");
        db.execSQL("create table " +Table2 + " (Drug_ID INTEGER PRIMARY KEY, Drug_Name TEXT, Drug_Genre INTEGER, Drug_Form TEXT, Drug_Strength TEXT, Drug_Company INTEGER, Drug_Indication INTEGER, Drug_Class INTEGER)");
        db.execSQL("create table " +Table3 + " (Class_ID INTEGER PRIMARY KEY, Class_Name TEXT)");
        db.execSQL("create table " +Table4 + " (Company_ID INTEGER PRIMARY KEY, Company_Name TEXT, Company_Class INTEGER, Company_Genre INTEGER, Company_Indication INTEGER)");
        db.execSQL("create table " +Table5 + " (Genre_ID INTEGER PRIMARY KEY, Genre_Name TEXT)");
        db.execSQL("create table " +Table6 + " (User_ID INTEGER, Drug_ID INTEGER)");
        db.execSQL("create table " +Table7 + " (Indication_ID PRIMARY KEY, Indication_Name TEXT)");
        this.db = db;
        insertClasses(db);
        insertIndications(db);
        insertGenre(db);
        insertCompany(db);
        insertDrugs(db);
    }
    public void insertIndications(SQLiteDatabase db){
        //db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from " + Table7;
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(T7_Col1, count);
        values.put(T7_Col2, "Fever ans Mild to moderate pain such as osteoarthritis, rheumatoid arthritis, chronic low back pain, Renal stone postoperative mild to moderate pain");
        db.insert(Table7, null, values);
        count++;

        values.put(T7_Col1, count);
        values.put(T7_Col2, "Cardian arrest, Anaphylaxiz, Superficial bleeding, acute asthma");
        db.insert(Table7, null, values);
        count++;

        values.put(T7_Col1, count);
        values.put(T7_Col2, "Bacterial Ear Infection");
        db.insert(Table7, null, values);
        count++;

        values.put(T7_Col1, count);
        values.put(T7_Col2, "Diaabetes Mellitus");
        db.insert(Table7, null, values);
        count++;

        values.put(T7_Col1, count);
        values.put(T7_Col2, "Protection from harmful UV rays. Ideal for those with photodermatoses & reduced skin pigmentation, sunblock");
        db.insert(Table7, null, values);
        count++;

        values.put(T7_Col1, count);
        values.put(T7_Col2, "Major depressive disorder");
        db.insert(Table7, null, values);
        count++;

        values.put(T7_Col1, count);
        values.put(T7_Col2, "Chronic hepatitis B");
        db.insert(Table7, null, values);
        count++;

        values.put(T7_Col1, count);
        values.put(T7_Col2, "Cryptococcal meningtitis, candidiasis, tinea pedis, tinea cruris, tines corporis, Vaginal candidiatis, onychomycosis, Coccidiodomycosis, Cryptococcosis, Histoplasmosis, Mucosal Candidiasis, Candidal balanitis, Dermatophytosis");
        db.insert(Table7, null, values);
        count++;
    }

    public ArrayList<String> getIndications(){
        ArrayList<String> indications = new ArrayList<String>();
        db = this.getReadableDatabase();
        String query = "select Indication_Name from " + Table7;
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            do{
                indications.add(cursor.getString(0));
            }while (cursor.moveToNext());
        }

        return indications;
    }

    public void insertClasses(SQLiteDatabase db){
        //db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from " + Table3;
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(T3_Col1, count);
        values.put(T3_Col2, "Non Opiod Analgesic");
        db.insert(Table3, null, values);
        count++;

        values.put(T3_Col1, count);
        values.put(T3_Col2, "Anaphylaxis");
        db.insert(Table3, null, values);
        count++;

        values.put(T3_Col1, count);
        values.put(T3_Col2, "Aural Preparation");
        db.insert(Table3, null, values);
        count++;

        values.put(T3_Col1, count);
        values.put(T3_Col2, "Anti-diabetic (oral Hypoglycemic drugs)");
        db.insert(Table3, null, values);
        count++;

        values.put(T3_Col1, count);
        values.put(T3_Col2, "Sunblock Preperation");
        db.insert(Table3, null, values);
        count++;

        values.put(T3_Col1, count);
        values.put(T3_Col2, "Atypical anti-depressent drugs");
        db.insert(Table3, null, values);
        count++;

        values.put(T3_Col1, count);
        values.put(T3_Col2, "Anti histamine Preparation");
        db.insert(Table3, null, values);
        count++;

        values.put(T3_Col1, count);
        values.put(T3_Col2, "Hepatic viral infection (Hepatitis \uD83D\uDE0E)");
        db.insert(Table3, null, values);
        count++;

        values.put(T3_Col1, count);
        values.put(T3_Col2, "Drugs for cuteneous mycosis");
        db.insert(Table3, null, values);
        count++;

        values.put(T3_Col1, count);
        values.put(T3_Col2, "Drugs for Iron Deficiancy Anemia");
        db.insert(Table3, null, values);
        count++;

        values.put(T3_Col1, count);
        values.put(T3_Col2, "Thyroid drugs & hormones");
        db.insert(Table3, null, values);
        count++;

        values.put(T3_Col1, count);
        values.put(T3_Col2, "Drugs for Hemorrhagic Stroke");
        db.insert(Table3, null, values);
        count++;

        values.put(T3_Col1, count);
        values.put(T3_Col2, "Drugs for bone formation");
        db.insert(Table3, null, values);
        count++;

    }

    public ArrayList<String> getClasses(){
        ArrayList<String> classes = new ArrayList<String>();
        db = this.getReadableDatabase();
        String query = "select Class_Name from " + Table3;
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            do{
                classes.add(cursor.getString(0));
            }while (cursor.moveToNext());
        }

        return classes;
    }

    public void insertGenre(SQLiteDatabase db){
        ContentValues values = new ContentValues();

        String query = "select * from " + Table5;
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(T5_Col1, count);
        values.put(T5_Col2, "Paracetamol");
        db.insert(Table5, null, values);
        count++;

        values.put(T5_Col1, count);
        values.put(T5_Col2, "Adrenalin");
        db.insert(Table5, null, values);
        count++;

        values.put(T5_Col1, count);
        values.put(T5_Col2, "Chloramphenicol ear drops");
        db.insert(Table5, null, values);
        count++;

        values.put(T5_Col1, count);
        values.put(T5_Col2, "Voglibose");
        db.insert(Table5, null, values);
        count++;

        values.put(T5_Col1, count);
        values.put(T5_Col2, "Microfine zinc oxide 15%");
        db.insert(Table5, null, values);
        count++;

        values.put(T5_Col1, count);
        values.put(T5_Col2, "Agomelatin");
        db.insert(Table5, null, values);
        count++;

        values.put(T5_Col1, count);
        values.put(T5_Col2, "Pizotifen");
        db.insert(Table5, null, values);
        count++;

        values.put(T5_Col1, count);
        values.put(T5_Col2, "Adefovir Dipivoxil");
        db.insert(Table5, null, values);
        count++;

        values.put(T5_Col1, count);
        values.put(T5_Col2, "Flugal 200");
        db.insert(Table5, null, values);
        count++;

        values.put(T5_Col1, count);
        values.put(T5_Col2, "Iron+Folic acid+Vitamin B+Vitamin C");
        db.insert(Table5, null, values);
        count++;

        values.put(T5_Col1, count);
        values.put(T5_Col2, "Thyroxine/LEvothyroxine Sodium");
        db.insert(Table5, null, values);
        count++;

        values.put(T5_Col1, count);
        values.put(T5_Col2, "Mannitol 20%");
        db.insert(Table5, null, values);
        count++;

        values.put(T5_Col1, count);
        values.put(T5_Col2, "Alfacalcidol");
        db.insert(Table5, null, values);
        count++;

        values.put(T5_Col1, count);
        values.put(T5_Col2, "Nandrolone");
        db.insert(Table5, null, values);
        count++;

        values.put(T5_Col1, count);
        values.put(T5_Col2, "Triamcinolone Acetonide");
        db.insert(Table5, null, values);
        count++;

        values.put(T5_Col1, count);
        values.put(T5_Col2, "Oxaprozin");
        db.insert(Table5, null, values);
        count++;

        values.put(T5_Col1, count);
        values.put(T5_Col2, "Flurbiprufen");
        db.insert(Table5, null, values);
        count++;

        values.put(T5_Col1, count);
        values.put(T5_Col2, "Loperamide");
        db.insert(Table5, null, values);
        count++;

        values.put(T5_Col1, count);
        values.put(T5_Col2, "Ispaghula Husk+Mebeverine Hydrochloride");
        db.insert(Table5, null, values);
        count++;
    }

    public void insertUserDetails(User c){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from " + Table1;
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(T1_Col1,count);
        values.put(T1_Col2, c.getUname());
        values.put(T1_Col3, c.getEmail());
        values.put(T1_Col4, c.getPass());

        db.insert(Table1, null, values);

        db.close();
    }
    public void insertCompany(SQLiteDatabase db){
        String query = "select * from " + Table4;
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        ContentValues values = new ContentValues();

        values.put(T4_Col1,count);
        values.put(T4_Col2,"Amico Laboratories Ltd.");
        values.put(T4_Col3,"0");
        values.put(T4_Col4,"0");
        values.put(T4_Col5,"0");
        db.insert(Table4, null, values);
        count++;

        values.put(T4_Col1,count);
        values.put(T4_Col2,"G.A. Company Ltd.");
        values.put(T4_Col3,"1");
        values.put(T4_Col4,"1");
        values.put(T4_Col5,"1");
        db.insert(Table4, null, values);
        count++;

        values.put(T4_Col1,count);
        values.put(T4_Col2,"Renata Limited");
        values.put(T4_Col3,"2");
        values.put(T4_Col4,"2");
        values.put(T4_Col5,"2");
        db.insert(Table4, null, values);
        count++;

        values.put(T4_Col1,count);
        values.put(T4_Col2,"Beximco PharmaCeutical");
        values.put(T4_Col3,"3");
        values.put(T4_Col4,"3");
        values.put(T4_Col5,"3");
        db.insert(Table4, null, values);
        count++;

        values.put(T4_Col1,count);
        values.put(T4_Col2,"GlaxoSmithKline Bangladesh Ltd.");
        values.put(T4_Col3,"4");
        values.put(T4_Col4,"4");
        values.put(T4_Col5,"4");
        db.insert(Table4, null, values);
        count++;

        values.put(T4_Col1,count);
        values.put(T4_Col2,"Beacon Pharmaceuticals Ltd.");
        values.put(T4_Col3,"5");
        values.put(T4_Col4,"5");
        values.put(T4_Col5,"5");
        db.insert(Table4, null, values);
        count++;

        values.put(T4_Col1,count);
        values.put(T4_Col2,"Opsonin Pharma Limited");
        values.put(T4_Col3,"6");
        values.put(T4_Col4,"6");
        values.put(T4_Col5,"6");
        db.insert(Table4, null, values);
        count++;

        values.put(T4_Col1,count);
        values.put(T4_Col2,"Techno Drugs Ltd.");
        values.put(T4_Col3,"6");
        values.put(T4_Col4,"6");
        values.put(T4_Col5,"6");
        db.insert(Table4, null, values);
        count++;

        values.put(T4_Col1,count);
        values.put(T4_Col2,"Square Pharmaceuticals Ltd.");
        values.put(T4_Col3,"7");
        values.put(T4_Col4,"7");
        values.put(T4_Col5,"7");
        db.insert(Table4, null, values);
        count++;


        values.put(T4_Col1,count);
        values.put(T4_Col2,"Leo Pharmaceutical products, Denmark");
        values.put(T4_Col3,"12");
        values.put(T4_Col4,"12");
        values.put(T4_Col5,"12");
        db.insert(Table4, null, values);
        count++;


        values.put(T4_Col1,count);
        values.put(T4_Col2,"Incepta Pharmaceutical Ltd.");
        values.put(T4_Col3,"14");
        values.put(T4_Col4,"14");
        values.put(T4_Col5,"14");
        db.insert(Table4, null, values);
        count++;

        values.put(T4_Col1,count);
        values.put(T4_Col2,"ACI limited");
        values.put(T4_Col3,"15");
        values.put(T4_Col4,"15");
        values.put(T4_Col5,"15");
        db.insert(Table4, null, values);
        count++;

        values.put(T4_Col1,count);
        values.put(T4_Col2,"General Pharmaceuticals Ltd.");
        values.put(T4_Col3,"16");
        values.put(T4_Col4,"16");
        values.put(T4_Col5,"16");
        db.insert(Table4, null, values);
        count++;

        values.put(T4_Col1,count);
        values.put(T4_Col2,"G.A. Company Ltd.");
        values.put(T4_Col3,"1");
        values.put(T4_Col4,"1");
        values.put(T4_Col5,"1");
        db.insert(Table4, null, values);
        count++;


    }

    public void insertDrugs(SQLiteDatabase db){

        String query = "select * from " + Table2;
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        ContentValues values = new ContentValues();

        values.put(T2_Col1,count);
        values.put(T2_Col2,"Para");
        values.put(T2_Col3,"0");
        values.put(T2_Col4,"Tablet");
        values.put(T2_Col5,"500 mg");
        values.put(T2_Col6,"0");
        values.put(T2_Col7,"0");
        values.put(T2_Col8,"0");
        db.insert(Table2, null, values);
        count++;


        values.put(T2_Col1,count);
        values.put(T2_Col2,"Adrin");
        values.put(T2_Col3,"1");
        values.put(T2_Col4,"Injection");
        values.put(T2_Col5,"1 mg");
        values.put(T2_Col6,"1");
        values.put(T2_Col7,"1");
        values.put(T2_Col8,"1");
        db.insert(Table2, null, values);
        count++;

        values.put(T2_Col1,count);
        values.put(T2_Col2,"Chloramex E/E");
        values.put(T2_Col3,"2");
        values.put(T2_Col4,"Ear drops");
        values.put(T2_Col5,"0.5%");
        values.put(T2_Col6,"2");
        values.put(T2_Col7,"2");
        values.put(T2_Col8,"2");
        db.insert(Table2, null, values);
        count++;

        values.put(T2_Col1,count);
        values.put(T2_Col2,"Vibose");
        values.put(T2_Col3,"3");
        values.put(T2_Col4,"Tablet");
        values.put(T2_Col5,"300 mg");
        values.put(T2_Col6,"3");
        values.put(T2_Col7,"3");
        values.put(T2_Col8,"3");
        db.insert(Table2, null, values);
        count++;

        values.put(T2_Col1,count);
        values.put(T2_Col2,"Spectraban 19");
        values.put(T2_Col3,"4");
        values.put(T2_Col4,"Cream");
        values.put(T2_Col5,"15%");
        values.put(T2_Col6,"4");
        values.put(T2_Col7,"4");
        values.put(T2_Col8,"4");
        db.insert(Table2, null, values);
        count++;

        values.put(T2_Col1,count);
        values.put(T2_Col2,"Agotin");
        values.put(T2_Col3,"5");
        values.put(T2_Col4,"Tablet");
        values.put(T2_Col5,"25 mg");
        values.put(T2_Col6,"5");
        values.put(T2_Col7,"5");
        values.put(T2_Col8,"5");
        db.insert(Table2, null, values);
        count++;

        values.put(T2_Col1,count);
        values.put(T2_Col2,"Pifen");
        values.put(T2_Col3,"6");
        values.put(T2_Col4,"Tablet");
        values.put(T2_Col5,"500mg");
        values.put(T2_Col6,"6");
        values.put(T2_Col7,"6");
        values.put(T2_Col8,"6");
        db.insert(Table2, null, values);
        count++;

        values.put(T2_Col1,count);
        values.put(T2_Col2,"Migofen");
        values.put(T2_Col3,"6");
        values.put(T2_Col4,"Tablet");
        values.put(T2_Col5,"1.5mg");
        values.put(T2_Col6,"7");
        values.put(T2_Col7,"6");
        values.put(T2_Col8,"6");
        db.insert(Table2, null, values);
        count++;

        values.put(T2_Col1,count);
        values.put(T2_Col2,"Adovir");
        values.put(T2_Col3,"7");
        values.put(T2_Col4,"Tablet");
        values.put(T2_Col5,"10mg");
        values.put(T2_Col6,"2");
        values.put(T2_Col7,"7");
        values.put(T2_Col8,"7");
        db.insert(Table2, null, values);
        count++;

        values.put(T2_Col1,count);
        values.put(T2_Col2,"Flugal");
        values.put(T2_Col3,"8");
        values.put(T2_Col4,"Capsule");
        values.put(T2_Col5,"200mg");
        values.put(T2_Col6,"8");
        values.put(T2_Col7,"8");
        values.put(T2_Col8,"8");
        db.insert(Table2, null, values);
        count++;

        values.put(T2_Col1,count);
        values.put(T2_Col2,"Fefovit");
        values.put(T2_Col3,"9");
        values.put(T2_Col4,"Capsule");
        values.put(T2_Col5,"2mg");
        values.put(T2_Col6,"4");
        values.put(T2_Col7,"9");
        values.put(T2_Col8,"9");
        db.insert(Table2, null, values);
        count++;


        values.put(T2_Col1,count);
        values.put(T2_Col2,"Thyrin 50");
        values.put(T2_Col3,"10");
        values.put(T2_Col4,"Tablet");
        values.put(T2_Col5,"50mg");
        values.put(T2_Col6,"8");
        values.put(T2_Col7,"10");
        values.put(T2_Col8,"10");
        db.insert(Table2, null, values);
        count++;

        values.put(T2_Col1,count);
        values.put(T2_Col2,"Osmosol 20% IV");
        values.put(T2_Col3,"11");
        values.put(T2_Col4,"Infusion");
        values.put(T2_Col5,"20%");
        values.put(T2_Col6,"3");
        values.put(T2_Col7,"11");
        values.put(T2_Col8,"11");
        db.insert(Table2, null, values);
        count++;

        values.put(T2_Col1,count);
        values.put(T2_Col2,"One Alpha");
        values.put(T2_Col3,"12");
        values.put(T2_Col4,"Capsule");
        values.put(T2_Col5,"0.25mcg");
        values.put(T2_Col6,"9");
        values.put(T2_Col7,"12");
        values.put(T2_Col8,"12");
        db.insert(Table2, null, values);
        count++;

        values.put(T2_Col1,count);
        values.put(T2_Col2,"Nandron");
        values.put(T2_Col3,"13");
        values.put(T2_Col4,"Injection");
        values.put(T2_Col5,"25 mg");
        values.put(T2_Col6,"2");
        values.put(T2_Col7,"13");
        values.put(T2_Col8,"13");
        db.insert(Table2, null, values);
        count++;


        values.put(T2_Col1,count);
        values.put(T2_Col2,"Cenolon Injection");
        values.put(T2_Col3,"14");
        values.put(T2_Col4,"Injection");
        values.put(T2_Col5,"40");
        values.put(T2_Col6,"10");
        values.put(T2_Col7,"14");
        values.put(T2_Col8,"14");
        db.insert(Table2, null, values);
        count++;

        values.put(T2_Col1,count);
        values.put(T2_Col2,"Demarin");
        values.put(T2_Col3,"15");
        values.put(T2_Col4,"Tablet");
        values.put(T2_Col5,"600 mg");
        values.put(T2_Col6,"11");
        values.put(T2_Col7,"15");
        values.put(T2_Col8,"14");
        db.insert(Table2, null, values);
        count++;

        values.put(T2_Col1,count);
        values.put(T2_Col2,"Urbifen");
        values.put(T2_Col3,"16");
        values.put(T2_Col4,"Tablet");
        values.put(T2_Col5,"50mg");
        values.put(T2_Col6,"12");
        values.put(T2_Col7,"16");
        values.put(T2_Col8,"14");
        db.insert(Table2, null, values);
        count++;

        values.put(T2_Col1,count);
        values.put(T2_Col2,"Normotil");
        values.put(T2_Col3,"17");
        values.put(T2_Col4,"Capsule");
        values.put(T2_Col5,"2mg");
        values.put(T2_Col6,"3");
        values.put(T2_Col7,"17");
        values.put(T2_Col8,"15");
        db.insert(Table2, null, values);
        count++;

        values.put(T2_Col1,count);
        values.put(T2_Col2,"Fiberlax Ultra Effervescent GR");
        values.put(T2_Col3,"18");
        values.put(T2_Col4,"Sachet");
        values.put(T2_Col5,"3.5mg+135mg");
        values.put(T2_Col6,"10");
        values.put(T2_Col7,"18");
        values.put(T2_Col8,"16");
        db.insert(Table2, null, values);
        count++;


    }

    public ArrayList<String> getDrugs(){
        ArrayList<String> drugs = new ArrayList<String>();
        db = this.getReadableDatabase();
        String query = "select Drug_Name from " + Table2;
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            do{
                drugs.add(cursor.getString(0));
            }while (cursor.moveToNext());
        }
        return  drugs;
    }

    public ArrayList<String> getDrugByClass(int classID){
        ArrayList<String> drugs = new ArrayList<String>();
        db = this.getReadableDatabase();
        String query = "select Drug_Name from " + Table2 + " where Drug_Class = " + Integer.toString(classID);
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            do{
                drugs.add(cursor.getString(0));
            }while (cursor.moveToNext());
        }
        return drugs;
    }

    public ArrayList<String> getDrugByIndication(int indicationID){
        ArrayList<String> drugs = new ArrayList<String>();
        db = this.getReadableDatabase();
        String query = "select Drug_Name from " + Table2 + " where Drug_Indication = " + Integer.toString(indicationID);
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            do{
                drugs.add(cursor.getString(0));
            }while (cursor.moveToNext());
        }
        return drugs;
    }

    public String getCompany(String drugName){
        String company = "";
        db = this.getReadableDatabase();
        String query = "select Company_Name from " + Table4 + " where Company_ID in (select Drug_Company from " + Table2 + " where Drug_Name like '" + drugName +"')";
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            company = cursor.getString(0);
        }

        return company;
    }

    public String getForm(String drugName){
        String form = "";
        db = this.getReadableDatabase();
        String query = "select Drug_Form from " + Table2 + " where Drug_Name like '" + drugName + "'";
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            form = cursor.getString(0);
        }

        return form;
    }

    public String getStrength(String drugName){
        String form = "";
        db = this.getReadableDatabase();
        String query = "select Drug_Strength from " + Table2 + " where Drug_Name like '" + drugName + "'";
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            form = cursor.getString(0);
        }

        return form;
    }

    public String getIndication(String drugName){
        String company = "";
        db = this.getReadableDatabase();
        String query = "select Indication_Name from " + Table7 + " where Indication_ID in (select Drug_Indication from " + Table2 + " where Drug_Name like '" + drugName +"')";
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            company = cursor.getString(0);
        }

        return company;
    }

    public String getClass(String drugName){
        String company = "";
        db = this.getReadableDatabase();
        String query = "select Class_Name from " + Table3 + " where Class_ID in (select Drug_Class from " + Table2 + " where Drug_Name like '" + drugName +"')";
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            company = cursor.getString(0);
        }

        return company;
    }


    public String searchPass(String uname){
        db = this.getReadableDatabase();

        String query = "select User_Name, User_Password from " + Table1;
        Cursor cursor = db.rawQuery(query, null);
        String a,b;
        b = "not found";
        if(cursor.moveToFirst()){
            do{
                a = cursor.getString(0);
                if(a.equals(uname)){
                    b = cursor.getString(1);
                    break;
                }
            }while(cursor.moveToNext());
        }

        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS "+Table1;
        db.execSQL(query);
        query = "DROP TABLE IF EXISTS "+Table2;
        db.execSQL(query);
        query = "DROP TABLE IF EXISTS "+Table3;
        db.execSQL(query);
        query = "DROP TABLE IF EXISTS "+Table4;
        db.execSQL(query);
        query = "DROP TABLE IF EXISTS "+Table5;
        db.execSQL(query);
        query = "DROP TABLE IF EXISTS "+Table6;
        db.execSQL(query);
        query = "DROP TABLE IF EXISTS "+Table7;
        db.execSQL(query);
        this.onCreate(db);
    }
}
