package test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.spider.bean.JobBatchMainInfo;
import com.spider.bean.JobContent;
import com.spider.dao.MongodbDao;

public class mongoDbQueryTestCase extends BaseSpringTestCase{
	
	@Autowired
	private MongodbDao<JobBatchMainInfo> mongodbDao;
	
	public void testQuery(){
		Query query = new Query();
		query.addCriteria(Criteria.where("batchNo").is("1472027175001"));
		List<JobBatchMainInfo> list = mongodbDao.findList(query, JobBatchMainInfo.class);
		if(list!=null){
			System.out.println("list="+list.size());
			for (JobBatchMainInfo job:list) {
				System.out.println("222="+job.getBatchNo());
			}
		}
		
	}
	
	
	@Test
	public void testAdd(){
		String batchNo = System.currentTimeMillis() + "";
		JobBatchMainInfo batchMainInfo = new JobBatchMainInfo(batchNo, 100L,"test-batchID");
		batchMainInfo.setStatus(JobContent.STATUS_PROCESS);
		mongodbDao.save(batchMainInfo);
		System.out.println("保存完成");
		
	}
	
}
