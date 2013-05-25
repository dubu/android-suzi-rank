package com.suzi.rank.dubu;

import android.accounts.AccountManager;
import android.content.Context;

import com.suzi.rank.dubu.authenticator.BootstrapAuthenticatorActivity;
import com.suzi.rank.dubu.authenticator.LogoutService;
import com.suzi.rank.dubu.core.CheckIn;
import com.suzi.rank.dubu.core.TimerService;
import com.suzi.rank.dubu.ui.BootstrapTimerActivity;
import com.suzi.rank.dubu.ui.CarouselActivity;
import com.suzi.rank.dubu.ui.CheckInsListFragment;
import com.suzi.rank.dubu.ui.ItemListFragment;
import com.suzi.rank.dubu.ui.NewsActivity;
import com.suzi.rank.dubu.ui.NewsListFragment;
import com.suzi.rank.dubu.ui.UserActivity;
import com.suzi.rank.dubu.ui.UserListFragment;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module for setting up provides statements.
 * Register all of your entry points below.
 */
@Module
(
        complete = false,

        injects = {
                BootstrapApplication.class,
                BootstrapAuthenticatorActivity.class,
                CarouselActivity.class,
                BootstrapTimerActivity.class,
                CheckInsListFragment.class,
                NewsActivity.class,
                NewsListFragment.class,
                UserActivity.class,
                UserListFragment.class,
                TimerService.class
        }

)
public class BootstrapModule  {

    @Singleton
    @Provides
    Bus provideOttoBus() {
        return new Bus();
    }

    @Provides
    @Singleton
    LogoutService provideLogoutService(final Context context, final AccountManager accountManager) {
        return new LogoutService(context, accountManager);
    }

}
