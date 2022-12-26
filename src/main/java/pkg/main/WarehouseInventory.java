package pkg.main;
import org.apache.log4j.BasicConfigurator;
import org.apache.poi.xssf.usermodel.*;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.ArrayList;

public class WarehouseInventory {
    static DLLDictionary <String, Inventory> invRecord;

    public static void main(String[] args) throws IOException {
        //Test DataBase creation with Excel
        System.out.println(createDataBase("src/main/resources/Inventory.xlsx", "Inventory List"));

        //Test index problem 1.1
        int[] IndexTest = createIndex("unitPrice");
        assert IndexTest != null;
        System.out.print("Index of unitPrice using Quick Sorting: ");
        for (int j : IndexTest) {
            System.out.print(j + " ");
        }
        System.out.println("");

        //test index problem 1.2
        System.out.print("Index of unitPrice using BST:           ");
        BSTDictionary BSTTEST = createIndexBST("unitPrice");
        System.out.println(BSTTEST);

        //test problem 2
        System.out.print("Index of of unitPrice 10% perct number: ");
        System.out.println(query("unitPrice",10));
    }

    public static DLLDictionary createDataBase (String pathToFile, String sheetName) throws IOException {

        BasicConfigurator.configure();
        String path = new File(pathToFile).getAbsolutePath();
        FileInputStream inputStream = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(3).getLastCellNum();

        invRecord = new DLLDictionary <> ();

        for(int r=3; r<=(rows);r++){
            XSSFRow row = sheet.getRow(r);
            XSSFCell[] datas = new XSSFCell[10];
            for(int c=2;c<=(cols-1);c++){
                XSSFCell cell = row.getCell(c);
                datas[c-2] = cell;
            }
            invRecord.insert(datas[0].getStringCellValue(),
                    new Inventory(datas[0].getStringCellValue(),datas[1].getStringCellValue(),
                            datas[2].getStringCellValue(),datas[3].getNumericCellValue(),datas[4].getNumericCellValue(),
                            datas[3].getNumericCellValue()*datas[4].getNumericCellValue(),datas[6].getNumericCellValue(),
                            datas[7].getNumericCellValue(),datas[8].getNumericCellValue(),datas[9].getBooleanCellValue()));
        }
        return invRecord;
    }

    //Problem 1.1 method

    //#1.1 Method that creates an index for each attribute of invRecord
    //Question : Discuss your solution’s asymptotic analysis in the function’s comments on the time complexity and space complexity

    //Answer: The createIndex function uses quicksort with a time complexity of nlog(n) but
    // has Θ(n) space complexity since it must build a new list of size  n
    public static int[] createIndex(String attribute){

        switch (attribute) {
            case "inventoryID" -> {
                DLList list = invRecord.getList();
                list.moveToStart();
                list.next();
                ArrayList<String> result = new ArrayList<>();

                int count = 0;
                while (count < list.length()) {
                    count++;
                    result.add(((Inventory) (((KVpair) (list.curr.element())).getValue())).getInventoryID());
                    list.next();
                }
                ArrayList<String> result2 = (ArrayList<String>) result.clone();

                int[] result3 = new int[count];
                quickSort1(result, 0, count - 1);
                for (int i = 0; i < result2.size(); i++) {
                    result3[i] = result.indexOf(result2.get(i));
                }
                return result3;
            }
            case "name" -> {
                DLList list = invRecord.getList();
                list.moveToStart();
                list.next();
                ArrayList<String> result = new ArrayList<>();

                int count = 0;
                while (count < list.length()) {
                    count++;
                    result.add(((Inventory) (((KVpair) (list.curr.element())).getValue())).getName());
                    list.next();
                }
                ArrayList<String> result2 = (ArrayList<String>) result.clone();

                int[] result3 = new int[count];

                quickSort1(result, 0, count - 1);
                for (int i = 0; i < result2.size(); i++) {
                    result3[i] = result.indexOf(result2.get(i));
                }
                return result3;
            }
            case "description" -> {
                DLList list = invRecord.getList();
                list.moveToStart();
                list.next();
                ArrayList<String> result = new ArrayList<>();

                int count = 0;
                while (count < list.length()) {
                    count++;
                    result.add(((Inventory) (((KVpair) (list.curr.element())).getValue())).getDescription());
                    list.next();
                }
                ArrayList<String> result2 = (ArrayList<String>) result.clone();

                int[] result3 = new int[count];
                quickSort1(result, 0, count - 1);
                for (int i = 0; i < result2.size(); i++) {
                    result3[i] = result.indexOf(result2.get(i));
                }
                return result3;
            }
            case "unitPrice" -> {
                DLList list = invRecord.getList();
                list.moveToStart();
                list.next();
                ArrayList<Double> result = new ArrayList<>();

                int count = 0;
                while (count < list.length()) {
                    count++;
                    result.add(((Inventory) (((KVpair) (list.curr.element())).getValue())).getUnitPrice());
                    list.next();
                }
                ArrayList<Double> result2 = (ArrayList<Double>) result.clone();

                int[] result3 = new int[count];
                quickSort(result, 0, count - 1);
                for (int i = 0; i < result2.size(); i++) {
                    result3[i] = result.indexOf(result2.get(i));
                }
                return result3;
            }
            case "quantityInStock" -> {
                DLList list = invRecord.getList();
                list.moveToStart();
                list.next();
                ArrayList<Double> result = new ArrayList<>();

                int count = 0;
                while (count < list.length()) {
                    count++;
                    result.add(((Inventory) (((KVpair) (list.curr.element())).getValue())).getQuantityInStock());
                    list.next();
                }
                ArrayList<Double> result2 = (ArrayList<Double>) result.clone();

                int[] result3 = new int[count];
                quickSort(result, 0, count - 1);
                for (int i = 0; i < result2.size(); i++) {
                    result3[i] = result.indexOf(result2.get(i));
                }
                return result3;
            }
            case "inventoryValue" -> {
                DLList list = invRecord.getList();
                list.moveToStart();
                list.next();
                ArrayList<Double> result = new ArrayList<>();

                int count = 0;
                while (count < list.length()) {
                    count++;
                    result.add(((Inventory) (((KVpair) (list.curr.element())).getValue())).getInventoryValue());
                    list.next();
                }
                ArrayList<Double> result2 = (ArrayList<Double>) result.clone();

                int[] result3 = new int[count];
                quickSort(result, 0, count - 1);
                for (int i = 0; i < result2.size(); i++) {
                    result3[i] = result.indexOf(result2.get(i));
                }
                return result3;
            }
            case "reorderLevel" -> {
                DLList list = invRecord.getList();
                list.moveToStart();
                list.next();
                ArrayList<Double> result = new ArrayList<>();

                int count = 0;
                while (count < list.length()) {
                    count++;
                    result.add(((Inventory) (((KVpair) (list.curr.element())).getValue())).getReorderLevel());
                    list.next();
                }
                ArrayList<Double> result2 = (ArrayList<Double>) result.clone();

                int[] result3 = new int[count];
                quickSort(result, 0, count - 1);
                for (int i = 0; i < result2.size(); i++) {
                    result3[i] = result.indexOf(result2.get(i));
                }
                return result3;
            }
            case "reorderTime" -> {
                DLList list = invRecord.getList();
                list.moveToStart();
                list.next();
                ArrayList<Double> result = new ArrayList<>();

                int count = 0;
                while (count < list.length()) {
                    count++;
                    result.add(((Inventory) (((KVpair) (list.curr.element())).getValue())).getReorderTime());
                    list.next();
                }

                ArrayList<Double> result2 = (ArrayList<Double>) result.clone();

                int[] result3 = new int[count];
                quickSort(result, 0, count - 1);
                for (int i = 0; i < result2.size(); i++) {
                    result3[i] = result.indexOf(result2.get(i));
                }
                return result3;
            }
            case "quantityInReorder" -> {
                DLList list = invRecord.getList();
                list.moveToStart();
                list.next();
                ArrayList<Double> result = new ArrayList<>();

                int count = 0;
                while (count < list.length()) {
                    count++;
                    result.add(((Inventory) (((KVpair) (list.curr.element())).getValue())).getQuantityInReorder());
                    list.next();
                }

                ArrayList<Double> result2 = (ArrayList<Double>) result.clone();

                int[] result3 = new int[count];
                quickSort(result, 0, count - 1);
                for (int i = 0; i < result2.size(); i++) {
                    result3[i] = result.indexOf(result2.get(i));
                }
                return result3;
            }
            default -> {
                System.out.println("Invalid attribute!");
                return null;
            }
        }
    }

    //QuickSort1 is a method for an array list of strings
    public static void quickSort1(ArrayList<String> arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition1(arr, begin, end);

            quickSort1(arr, begin, partitionIndex-1);
            quickSort1(arr, partitionIndex+1, end);
        }
    }
    private static int partition1(ArrayList<String> arr, int begin, int end) {
        String pivot = arr.get(end);
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            int value = arr.get(j).compareTo(pivot);
            if (value<=0) {
                i++;
                String swapTemp = arr.get(i);
                arr.set(i,arr.get(j));
                arr.set(j,swapTemp);
            }
        }

        String swapTemp = arr.get(i+1);
        arr.set(i+1,arr.get(end));
        arr.set(end,swapTemp);

        return i+1;
    }

    //QuickSort for an array list of double
    public static void quickSort(ArrayList<Double> arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }
    private static int partition(ArrayList<Double> arr, int begin, int end) {
        double pivot = arr.get(end);
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr.get(j)<=pivot) {
                i++;
                double swapTemp = arr.get(i);
                arr.set(i,arr.get(j));
                arr.set(j,swapTemp);
            }
        }

        double swapTemp = arr.get(i+1);
        arr.set(i+1,arr.get(end));
        arr.set(end,swapTemp);

        return i+1;
    }

    //Problem 1.2 method
    public static BSTDictionary createIndexBST(String attribute) {

        switch(attribute)
        {
            case "inventoryID":{
                DLList list = invRecord.getList();
                list.moveToStart();
                list.next();

                ArrayList<String> ListResult = new ArrayList<>();
                BSTDictionary BSTResult = new BSTDictionary<>();

                int count = 0;
                while (count < list.length()) {
                    count++;
                    ListResult.add(((Inventory) (((KVpair) (list.curr.element())).getValue())).getInventoryID());
                    list.next();
                }
                for (int i = 0; i < ListResult.size(); i++) {
                    BSTResult.insert(ListResult.get(i), i);
                }

                BSTTraverse.clear();
                BSTTraverse.depthFirstTraverse(BSTResult.getRoot());
                String[] str = BSTTraverse.print().split(" ");

                int[] indexes = new int[BSTResult.size()];
                BSTResult.clear();
                for (int j = 0; j < ListResult.size(); j++) {
                    BSTResult.insert(str[j], j);
                }
                return BSTResult;
            }
            case "name": {
                DLList list = invRecord.getList();
                list.moveToStart();
                list.next();

                ArrayList<String> ListResult = new ArrayList<>();
                BSTDictionary BSTResult = new BSTDictionary<>();

                int count = 0;
                while (count < list.length()) {
                    count++;
                    ListResult.add(((Inventory) (((KVpair) (list.curr.element())).getValue())).getName());
                    list.next();
                }

                for (int i = 0; i < ListResult.size(); i++) {
                    BSTResult.insert(ListResult.get(i), i);
                }

                BSTTraverse.clear();
                BSTTraverse.depthFirstTraverse(BSTResult.getRoot());
                String[] str = BSTTraverse.print().split(" ");
                int[] indexes = new int[BSTResult.size()];
                BSTResult.clear();
                for (int j = 0; j < ListResult.size(); j++) {
                    BSTResult.insert(str[j], j);
                }
                return BSTResult;
            }
            case "description": {
                DLList list = invRecord.getList();
                list.moveToStart();
                list.next();

                ArrayList<String> ListResult = new ArrayList<>();
                BSTDictionary BSTResult = new BSTDictionary<>();

                int count = 0;
                while (count < list.length()) {
                    count++;
                    ListResult.add(((Inventory) (((KVpair) (list.curr.element())).getValue())).getDescription());
                    list.next();
                }

                for (int i = 0; i < ListResult.size(); i++) {
                    BSTResult.insert(ListResult.get(i), i);
                }

                BSTTraverse.clear();
                BSTTraverse.depthFirstTraverse(BSTResult.getRoot());
                String[] str = BSTTraverse.print().split(" ");

                int[] indexes = new int[BSTResult.size()];
                BSTResult.clear();
                for (int j = 0; j < ListResult.size(); j++) {
                    BSTResult.insert(str[j], j);
                }
                return BSTResult;
            }
            case "unitPrice": {
                DLList list = invRecord.getList();
                list.moveToStart();
                list.next();

                ArrayList<Double> ListResult = new ArrayList<>();
                BSTDictionary BSTResult = new BSTDictionary<>();

                int count = 0;
                while (count < list.length()) {
                    count++;
                    ListResult.add(((Inventory) (((KVpair) (list.curr.element())).getValue())).getUnitPrice());
                    list.next();
                }

                for (int i = 0; i < ListResult.size(); i++) {
                    BSTResult.insert(ListResult.get(i), i);
                }

                BSTTraverse.clear();
                BSTTraverse.depthFirstTraverse(BSTResult.getRoot());
                String[] str = BSTTraverse.print().split(" ");

                int[] indexes = new int[BSTResult.size()];
                BSTResult.clear();
                for (int j = 0; j < ListResult.size(); j++) {
                    BSTResult.insert(Double.parseDouble(str[j]), j);
                }
                return BSTResult;
            }
            case "quantityInStock": {
                DLList list = invRecord.getList();
                list.moveToStart();
                list.next();

                ArrayList<Double> ListResult = new ArrayList<>();
                BSTDictionary BSTResult = new BSTDictionary<>();

                int count = 0;
                while (count < list.length()) {
                    count++;
                    ListResult.add(((Inventory) (((KVpair) (list.curr.element())).getValue())).getQuantityInStock());
                    list.next();
                }

                for (int i = 0; i < ListResult.size(); i++) {
                    BSTResult.insert(ListResult.get(i), i);
                }

                BSTTraverse.clear();
                BSTTraverse.depthFirstTraverse(BSTResult.getRoot());
                String[] str = BSTTraverse.print().split(" ");

                int[] indexes = new int[BSTResult.size()];
                BSTResult.clear();
                for (int j = 0; j < ListResult.size(); j++) {
                    BSTResult.insert(Double.parseDouble(str[j]), j);
                }
                return BSTResult;
            }
            case "inventoryValue":{
                DLList list = invRecord.getList();
                list.moveToStart();
                list.next();

                ArrayList<Double> ListResult = new ArrayList<>();
                BSTDictionary BSTResult = new BSTDictionary<>();

                int count = 0;
                while (count < list.length()) {
                    count++;
                    ListResult.add(((Inventory) (((KVpair) (list.curr.element())).getValue())).getInventoryValue());
                    list.next();
                }

                for (int i = 0; i < ListResult.size(); i++) {
                    BSTResult.insert(ListResult.get(i), i);
                }

                BSTTraverse.clear();
                BSTTraverse.depthFirstTraverse(BSTResult.getRoot());
                String[] str = BSTTraverse.print().split(" ");

                int[] indexes = new int[BSTResult.size()];
                BSTResult.clear();
                for (int j = 0; j < ListResult.size(); j++) {
                    BSTResult.insert(Double.parseDouble(str[j]), j);
                }
                return BSTResult;
            }
            case "reorderLevel":{

                DLList list = invRecord.getList();
                list.moveToStart();
                list.next();

                ArrayList<Double> ListResult = new ArrayList<>();
                BSTDictionary BSTResult = new BSTDictionary<>();

                int count = 0;
                while (count < list.length()) {
                    count++;
                    ListResult.add(((Inventory) (((KVpair) (list.curr.element())).getValue())).getReorderLevel());
                    list.next();
                }

                for (int i = 0; i < ListResult.size(); i++) {
                    BSTResult.insert(ListResult.get(i), i);
                }

                BSTTraverse.clear();
                BSTTraverse.depthFirstTraverse(BSTResult.getRoot());
                String[] str = BSTTraverse.print().split(" ");

                int[] indexes = new int[BSTResult.size()];
                BSTResult.clear();
                for (int j = 0; j < ListResult.size(); j++) {
                    BSTResult.insert(Double.parseDouble(str[j]), j);
                }
                return BSTResult;
            }

            case "reorderTime": {
                DLList list = invRecord.getList();
                list.moveToStart();
                list.next();

                ArrayList<Double> ListResult = new ArrayList<>();
                BSTDictionary BSTResult = new BSTDictionary<>();

                int count = 0;
                while (count < list.length()) {
                    count++;
                    ListResult.add(((Inventory) (((KVpair) (list.curr.element())).getValue())).getReorderTime());
                    list.next();
                }

                for (int i = 0; i < ListResult.size(); i++) {
                    BSTResult.insert(ListResult.get(i), i);
                }

                BSTTraverse.clear();
                BSTTraverse.depthFirstTraverse(BSTResult.getRoot());
                String[] str = BSTTraverse.print().split(" ");

                int[] indexes = new int[BSTResult.size()];
                BSTResult.clear();
                for (int j = 0; j < ListResult.size(); j++) {
                    BSTResult.insert(Double.parseDouble(str[j]), j);
                }
                return BSTResult;
            }
            case "quantityInReorder":{
                DLList list = invRecord.getList();
                list.moveToStart();
                list.next();

                ArrayList<Double> ListResult = new ArrayList<>();
                BSTDictionary BSTResult = new BSTDictionary<>();

                int count = 0;
                while (count < list.length()) {
                    count++;
                    ListResult.add(((Inventory) (((KVpair) (list.curr.element())).getValue())).getQuantityInReorder());
                    list.next();
                }

                for (int i = 0; i < ListResult.size(); i++) {
                    BSTResult.insert(ListResult.get(i), i);
                }

                BSTTraverse.clear();
                BSTTraverse.depthFirstTraverse(BSTResult.getRoot());
                String[] str = BSTTraverse.print().split(" ");

                int[] indexes = new int[BSTResult.size()];
                BSTResult.clear();
                for (int j = 0; j < ListResult.size(); j++) {
                    BSTResult.insert(Double.parseDouble(str[j]), j);
                }
                return BSTResult;
            }
            default:
                System.out.println("Invalid attribute!");
                return null;
    }
}

    //Problem 2 method
    public static int query(String attribute, double perct) {
        int[] list2 = createIndex(attribute);
        if (list2 == null) {
            System.out.println("Attribute " + attribute + " does not exist");
        }
        int i = (int) Math.round((perct/100)*list2.length);
        return list2[i];
    }
}