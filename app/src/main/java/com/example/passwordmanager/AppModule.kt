package com.example.passwordmanager

import android.app.Application
import android.content.Context
import com.example.passwordmanager.db.AccountDao
import com.example.passwordmanager.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase {
        return AppDatabase.getDatabase(context)
    }

    @Provides
    @Singleton
    fun provideUserDao(appDatabase: AppDatabase): AccountDao {
        return appDatabase.accountDao()
    }
}
