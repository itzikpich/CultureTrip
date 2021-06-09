package com.itzikpich.culturetrip.network

import javax.inject.Inject

class Repository @Inject constructor(val remoteDataSourceImpl: RemoteDataSourceImpl) : RemoteDataSource by remoteDataSourceImpl