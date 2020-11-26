package ink.iamt.waterkeeper.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import ink.iamt.waterkeeper.db.AppDatabase
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideWaterDatabase(
            @ApplicationContext app: Context
    ) = Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            "water_database"
    ).build()


    @Singleton
    @Provides
    fun provideWaterDao(db: AppDatabase) = db.waterDao()
}