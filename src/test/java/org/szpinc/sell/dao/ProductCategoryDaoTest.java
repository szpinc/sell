package org.szpinc.sell.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.szpinc.sell.entity.ProductCategory;

import java.util.Arrays;
import java.util.List;

/*/*
 *  
 * 
 * @author SZP Inc.
 * @date 2018/3/22 下午9:42
 * @param 
 * @return 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryDaoTest {


    @Autowired
    private ProductCategoryDao productCategoryDao;

    /*/*
     *  
     * 
     * @author SZP Inc.
     * @date 2018/3/22 下午9:42
     * @param []
     * @return 
     */
    @Test
    public void testSave() {

        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("今日热卖");
        productCategory.setCategoryType(11);

        ProductCategory save = productCategoryDao.save(productCategory);

        if (save != null) {
            log.debug("保存成功");
        } else {
            log.debug("保存失败");
        }

    }

    /*
     *  
     * 
     * @author SZP Inc.
     * @date 2018/3/22 下午9:42
     * @param []
     * @return
     */
    @Test
    public void testGetOne () {
        ProductCategory productCategory = productCategoryDao.findOne(1);
        if (productCategory != null) {
            log.debug("获取的对象信息:[{}]",productCategory);
        } else {
            log.debug("信息不存在");
        }
    }

    @Test
    public void testUpdate () {
        ProductCategory productCategory = productCategoryDao.findOne(1);
        productCategory.setCategoryType(10);
        productCategoryDao.save(productCategory);
    }


    @Test
    public void findByCategoryTypeInTest () {
        List<Integer> list = Arrays.asList(2, 3, 4);
        List<Integer> categoryTypeList = productCategoryDao.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,categoryTypeList.size());
    }

}