package com.ipaynow.yishouyun.goods.provider.repository

import com.ipaynow.yishouyun.goods.provider.entity.GoodsInfo
import org.springframework.data.jpa.repository.JpaRepository

interface GoodsInfoRepository : JpaRepository<GoodsInfo, String> {

    fun findByStoreIdAndCategoryIdAndStatusGreaterThan(
            storeId: String,
            categoryId: Long,
            status: Int
    ): List<GoodsInfo>

    fun findByStoreIdAndStatusGreaterThan(
            storeId: String,
            status: Int
    ): List<GoodsInfo>
}