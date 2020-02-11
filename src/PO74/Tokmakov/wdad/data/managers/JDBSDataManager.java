package PO74.Tokmakov.wdad.data.managers;

import PO74.Tokmakov.wdad.learn.xml.Department;

import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.rmi.RemoteException;

public class JDBSDataManager implements DataManager{
    @Override
    public double salaryAverage() throws RemoteException, XPathExpressionException {
        return 0;
    }

    @Override
    public double salaryAverage(String departmentName) throws RemoteException, XPathExpressionException {
        return 0;
    }

    @Override
    public void setJobTitle(String firstName, String secondName, String newJobTitle) throws IOException, TransformerException {

    }

    @Override
    public void setSalary(String firstName, String secondName, int newSalary) throws IOException, TransformerException {

    }

    @Override
    public void fireEmployee(String fname, String sname) throws TransformerException, RemoteException {

    }

    @Override
    public void add(Department department) throws IOException {

    }
}
