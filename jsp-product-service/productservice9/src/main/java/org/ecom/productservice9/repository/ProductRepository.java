package org.ecom.productservice9.repository;

import java.util.Collections;
import java.util.List;

import org.ecom.productservice9.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.bytecode.internal.javassist.BulkAccessor;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public class ProductRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public Product createProduct(Product product) {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(product);
			transaction.commit();
			return product;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public double findProductPriceByProductId(@PathVariable("productId") long productId) {
		try {
			StringBuilder builder = new StringBuilder();
			builder.append("from Product where productId=:n");
			Session session = sessionFactory.openSession();
			Query query = session.createQuery(builder.toString());
			query.setParameter("n", productId);
//			return query.getResultList();
			return 205.06;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 123.0;

	}

	public Product getProductById(@PathVariable("alKey") Long id) {
		try {

			StringBuilder builder = new StringBuilder();
			builder.append("from Product where id=1");
			Session session = sessionFactory.openSession();
			Query query = session.createQuery(builder.toString());
			query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	public List<Product> getAllProducts() {
		try {
			String hqlQuery = "from Product";
			Session session = sessionFactory.openSession();
			Query query = session.createQuery(hqlQuery);
			return query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return Collections.EMPTY_LIST;

	}

	public Product saveAllProducts(Product product) {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(product);
			transaction.commit();
			return product;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return product;

	}

}