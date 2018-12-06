package battlequest.android.example.com.battlequest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySqliteOpenHelper extends SQLiteOpenHelper {

    private static final String database_name = "battle_quest.db";
    private String table_name = "users";
    private static final int version = 1;
    private String column_id = "id", column_name = "name";
    private String database_create_statement =
            "create table " + table_name +" ( "+column_id + " integer primary key autoincrement, "+ column_name+ " text not null );";




    public MySqliteOpenHelper(Context context) {
        super(context, database_name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(database_create_statement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}
