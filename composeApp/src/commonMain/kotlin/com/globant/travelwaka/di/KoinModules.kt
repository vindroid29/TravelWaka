package com.globant.travelwaka.di

import org.koin.core.module.Module
import org.koin.dsl.module

expect fun platformModule(): Module

val networkModule = module {

}

val viewModelModule = module {
//    factoryOf(::NoteListViewModel)
//    factoryOf(::NoteDetailsViewModel)
}

val provideRepositoryModule = module {
//    singleOf(::NotesRepositoryImpl).bind(NotesRepository::class)
}

val provideUseCaseModule = module {
//    singleOf(::GetAllNotesUseCase)
//    singleOf(::InsertNoteUseCase)
}
