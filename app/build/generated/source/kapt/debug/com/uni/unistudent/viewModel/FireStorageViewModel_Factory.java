// Generated by Dagger (https://dagger.dev).
package com.uni.unistudent.viewModel;

import com.uni.unistudent.data.FireStorageRepo;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class FireStorageViewModel_Factory implements Factory<FireStorageViewModel> {
  private final Provider<FireStorageRepo> repositoryProvider;

  public FireStorageViewModel_Factory(Provider<FireStorageRepo> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public FireStorageViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static FireStorageViewModel_Factory create(Provider<FireStorageRepo> repositoryProvider) {
    return new FireStorageViewModel_Factory(repositoryProvider);
  }

  public static FireStorageViewModel newInstance(FireStorageRepo repository) {
    return new FireStorageViewModel(repository);
  }
}
