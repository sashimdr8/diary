package com.diary.data.local

import com.diary.data.local.dao.DiaryDao
import io.realm.Realm

/**
 * Created by brain on 12/12/17.
 */
class RealmDbManager {

    private var mRealm: Realm? = null

    fun open(): Realm? {
        mRealm = Realm.getDefaultInstance()
        return mRealm
    }

    fun close() {
        if (mRealm != null) {
            mRealm!!.close()
        }
    }


    fun createDao(): DiaryDao {
        checkForOpenRealm()
        return DiaryDao(mRealm!!)
    }


    /*  public static void clear() {
          checkForOpenRealm();
          mRealm.executeTransaction(new Realm.Transaction() {
              @Override
              public void execute(Realm realm) {
                  realm.clear(JobsModel.class);
                  //clear rest of your dao classes
              }
          });
      }
  */
    private fun checkForOpenRealm() {
        if (mRealm == null || mRealm!!.isClosed) {
            throw IllegalStateException("RealmManager: Realm is closed, call open() method first")
        }
    }


}