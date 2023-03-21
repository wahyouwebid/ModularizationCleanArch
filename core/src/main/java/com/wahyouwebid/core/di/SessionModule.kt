package com.wahyouwebid.core.di

import android.content.Context
import com.wahyouwebid.core.database.Sessions
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object SessionModule {
    @Provides
    @Singleton
    fun provideSessions(@ApplicationContext context: Context): Sessions = Sessions(context)
}