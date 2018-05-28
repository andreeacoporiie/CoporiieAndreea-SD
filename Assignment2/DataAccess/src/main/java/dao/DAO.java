/*************************************************************************
 * ULLINK CONFIDENTIAL INFORMATION
 * _______________________________
 *
 * All Rights Reserved.
 *
 * NOTICE: This file and its content are the property of Ullink. The
 * information included has been classified as Confidential and may
 * not be copied, modified, distributed, or otherwise disseminated, in
 * whole or part, without the express written permission of Ullink.
 ************************************************************************/
package dao;

import java.sql.ResultSet;
import java.util.List;

public interface DAO<T>
{
    T findById(int id);

    void insert(T objectToCreate);

    void update(T objectToUpdate);
    
    void delete(T objectToDelete);

    List<T> findAll();

}
