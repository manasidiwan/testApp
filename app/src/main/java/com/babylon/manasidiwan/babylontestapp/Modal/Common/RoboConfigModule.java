package com.babylon.manasidiwan.babylontestapp.Modal.Common;

import android.app.Application;

import com.babylon.manasidiwan.babylontestapp.Logic.UserModel;
import com.babylon.manasidiwan.babylontestapp.Logic.UserModelImpl;
import com.babylon.manasidiwan.babylontestapp.Logic.UserProvider;
import com.babylon.manasidiwan.babylontestapp.Logic.UserProviderImpl;
import com.babylon.manasidiwan.babylontestapp.UI.Detail.DetailPresenter;
import com.babylon.manasidiwan.babylontestapp.UI.Detail.Impl.DetailPresenterImpl;
import com.babylon.manasidiwan.babylontestapp.UI.Home.HomePresenter;
import com.babylon.manasidiwan.babylontestapp.UI.Home.Impl.HomePresenterImpl;
import com.google.inject.AbstractModule;

/**
 * @author manasidiwan
 */
public class RoboConfigModule extends AbstractModule {

    /**
     * Constructor
     *
     * @param app application context
     */
    public RoboConfigModule(final Application app) {
    }

    @Override
    protected void configure() {
        bind(HomePresenter.class).to(HomePresenterImpl.class);
        bind(DetailPresenter.class).to(DetailPresenterImpl.class);
        bind(UserProvider.class).to(UserProviderImpl.class);
        bind(UserModel.class).to(UserModelImpl.class);
    }
}
