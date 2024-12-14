package helpers.mock.balanceBM.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import helpers.HelpFunc;
import helpers.jdbc.bfetch.MockJDBC;
import helpers.mock.balanceBM.pojo.RootBalance;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class BalanceBMMock {
    public static void addMock(String ctn, Integer sum) throws IOException, SQLException {
        ctn = HelpFunc.addSevenToCtn(ctn);

        File f = new File("src\\main\\resources\\mock\\mockBalance" + ctn + ".json");

        ObjectMapper myObjectMapper = new ObjectMapper();
        myObjectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        List<RootBalance> rootBalanceArrays = myObjectMapper.readValue(f, new TypeReference<>(){});

        //Установить сумму core балансу
        rootBalanceArrays.get(0).getRemainingValue().getValue().setValue(sum);

        String mockString = myObjectMapper.writeValueAsString(rootBalanceArrays);

        MockJDBC.insertMockTable(ctn, mockString, "balance");

    }

    public static void deleteBalanceMock(String ctn) throws SQLException {
        ctn = HelpFunc.addSevenToCtn(ctn);
        MockJDBC.deleteFromMockTable(ctn, "balance");
    }
}
