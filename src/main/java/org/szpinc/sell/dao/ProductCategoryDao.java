package org.szpinc.sell.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.szpinc.sell.entity.ProductCategory;

import java.util.List;

/*/*
 *  
 * 
 * @author SZP Inc.
 * @date 2018/3/22 下午9:58
 * @param
 * @return 
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategory,Integer> {

    /*/*
     *  
     * 
     * @author SZP Inc.
     * @date 2018/3/22 下午10:34
     * @param []
     * @return
     */
    List<Integer> findByCategoryTypeIn (List<Integer> list) ;


}
