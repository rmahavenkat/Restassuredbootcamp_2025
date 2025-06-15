package Utilities;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.testCaseData;
import java.io.File;
import java.util.List;

public class JSONDataReader {

	private static List<testCaseData> testData;

	// load data
	public static List<testCaseData> readJson(String filePath) {
		if (testData == null) {
			ObjectMapper mapper = new ObjectMapper();
			try {
				testData = mapper.readValue(new File(filePath), new TypeReference<List<testCaseData>>() {
				});
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Failed to load JSON test data from: " + filePath);
			}
		}
		return testData;
	}
 
	public static testCaseData getAllTestCase(String filePath,String testCaseId) {
		List<testCaseData> allData = readJson(filePath);
		for (testCaseData data : allData) {
			if (testCaseId.equals(data.getTestCaseId())) {
                return data;
            }
		}
		 throw new RuntimeException("Test case with ID " + testCaseId + " not found.");
	}
}
