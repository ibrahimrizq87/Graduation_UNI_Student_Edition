// Generated by Dagger (https://dagger.dev).
package com.uni.unistudent.data.di;

import com.google.firebase.database.DatabaseReference;
import com.uni.unistudent.data.FirebaseRealtimeRepo;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RepoModule_ProvideRealtimeRepoFactory implements Factory<FirebaseRealtimeRepo> {
  private final Provider<DatabaseReference> databaseProvider;

  public RepoModule_ProvideRealtimeRepoFactory(Provider<DatabaseReference> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public FirebaseRealtimeRepo get() {
    return provideRealtimeRepo(databaseProvider.get());
  }

  public static RepoModule_ProvideRealtimeRepoFactory create(
      Provider<DatabaseReference> databaseProvider) {
    return new RepoModule_ProvideRealtimeRepoFactory(databaseProvider);
  }

  public static FirebaseRealtimeRepo provideRealtimeRepo(DatabaseReference database) {
    return Preconditions.checkNotNullFromProvides(RepoModule.INSTANCE.provideRealtimeRepo(database));
  }
}
