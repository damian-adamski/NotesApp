package com.da.whatstodo.di

import android.app.Application
import androidx.room.Room
import com.da.whatstodo.featureNote.data.repository.NoteRepositoryImpl
import com.da.whatstodo.featureNote.data.source.NoteDatabase
import com.da.whatstodo.featureNote.domain.repository.NoteRepository
import com.da.whatstodo.featureNote.domain.useCase.DeleteNoteUseCase
import com.da.whatstodo.featureNote.domain.useCase.GetNotesUseCase
import com.da.whatstodo.featureNote.domain.useCase.NoteUseCases
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
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DatabaseName
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotesUseCase(repository),
            deleteNote = DeleteNoteUseCase(repository)
        )
    }
}