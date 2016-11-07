package org.starlabs.BenchmarkApplication;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.Starlabs.SortingBenchmark.Bubblesort;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.List;

public class BenchMarkApp {

	protected Shell SortingBenchmarkApplication;
	Display display;
	private Text textarraysize;
	private char arraytype;
	private int arraysize;
	private int[] array;
	private ArrayList<String> inputlist=  new ArrayList<String>();
	private ArrayList<String> outputlist=  new ArrayList<String>();

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BenchMarkApp window = new BenchMarkApp();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 * @throws FileNotFoundException 
	 */
	public void open() throws FileNotFoundException {
		display = Display.getDefault();
		createContents();
		SortingBenchmarkApplication.open();
		SortingBenchmarkApplication.layout();
		while (!SortingBenchmarkApplication.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * @throws FileNotFoundException 
	 */
	protected void createContents() throws FileNotFoundException {
		SortingBenchmarkApplication = new Shell();
		File file= new File("Benchmark.png");
		FileInputStream fileinput = new FileInputStream(file);
		Image img = new Image(display,fileinput);
		SortingBenchmarkApplication.setImage(img);
		SortingBenchmarkApplication.setSize(500, 600);
		SortingBenchmarkApplication.setText("Sorting Benchmark Application ");
		
		Label lblarraysizeLabel = new Label(SortingBenchmarkApplication, SWT.NONE);
		lblarraysizeLabel.setBounds(40, 40, 93, 15);
		lblarraysizeLabel.setText("Enter Array Size");
		
		Label lblChooseCase = new Label(SortingBenchmarkApplication, SWT.NONE);
		lblChooseCase.setBounds(40, 97, 93, 15);
		lblChooseCase.setText("Choose Case");
		
		textarraysize = new Text(SortingBenchmarkApplication, SWT.BORDER);
		textarraysize.setBounds(161, 40, 280, 21);
		
		Button btnBest = new Button(SortingBenchmarkApplication, SWT.RADIO);
		btnBest.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				arraytype='1';
			}
		});
		btnBest.setBounds(161, 97, 43, 16);
		btnBest.setText("Best");
		
		Button btnWorst = new Button(SortingBenchmarkApplication, SWT.RADIO);
		btnWorst.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				arraytype='2';
			}
		});
		btnWorst.setBounds(280, 96, 52, 16);
		btnWorst.setText("Worst");
		
		Button btnAverage = new Button(SortingBenchmarkApplication, SWT.RADIO);
		btnAverage.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				arraytype='3';
			}
		});
		btnAverage.setBounds(210, 96, 65, 16);
		btnAverage.setText("Average");
		
		Label statuslabel1 = new Label(SortingBenchmarkApplication, SWT.NONE);
		statuslabel1.setBounds(40, 129, 401, 21);
		
		Label label_1 = new Label(SortingBenchmarkApplication, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_1.setBounds(10, 165, 464, 2);
		
		Label lblChooseSortingAlgorithm = new Label(SortingBenchmarkApplication, SWT.NONE);
		lblChooseSortingAlgorithm.setBounds(40, 200, 158, 15);
		lblChooseSortingAlgorithm.setText("Choose Sorting Algorithm");
		
		Button btnBubbleSort = new Button(SortingBenchmarkApplication, SWT.CHECK);
		btnBubbleSort.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button btn = (Button) e.getSource();
				if(btn.getSelection()==true)
				inputlist.add(btnBubbleSort.getText());
				else
				inputlist.remove(btnBubbleSort.getText());
			}
		});
		btnBubbleSort.setBounds(204, 199, 93, 16);
		btnBubbleSort.setText("Bubble Sort");
		
		Button btnSelectionSort = new Button(SortingBenchmarkApplication, SWT.CHECK);
		btnSelectionSort.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button btn = (Button) e.getSource();
				if(btn.getSelection()==true)
				inputlist.add(btnSelectionSort.getText());
				else
					inputlist.remove(btnSelectionSort.getText());
			}
		});
		btnSelectionSort.setBounds(204, 221, 93, 16);
		btnSelectionSort.setText("Selection Sort");
		
		Button btnInsertionSort = new Button(SortingBenchmarkApplication, SWT.CHECK);
		btnInsertionSort.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button btn = (Button) e.getSource();
				if(btn.getSelection()==true)
				inputlist.add(btnInsertionSort.getText());
				else
					inputlist.remove(btnInsertionSort.getText());
			}
		});
		btnInsertionSort.setBounds(204, 243, 93, 16);
		btnInsertionSort.setText("Insertion Sort");
		
		Button btnQuickSort = new Button(SortingBenchmarkApplication, SWT.CHECK);
		btnQuickSort.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				 Button btn = (Button) e.getSource();
				if(btn.getSelection()==true)
				inputlist.add(btnQuickSort.getText());
				else
					inputlist.remove(btnQuickSort.getText());
			}
		});
		btnQuickSort.setBounds(204, 267, 93, 16);
		btnQuickSort.setText("Quick Sort");
		
		Button btnMergeSort = new Button(SortingBenchmarkApplication, SWT.CHECK);
		btnMergeSort.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button btn = (Button) e.getSource();
				if(btn.getSelection()==true)
				inputlist.add(btnMergeSort.getText());
				else
					inputlist.remove(btnMergeSort.getText());
			}
		});
		btnMergeSort.setBounds(204, 289, 93, 16);
		btnMergeSort.setText("Merge Sort");
		
		Label statuslabel2 = new Label(SortingBenchmarkApplication, SWT.NONE);
		statuslabel2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		statuslabel2.setBounds(40, 401, 401, 78);
		
		Button btnBenchmark = new Button(SortingBenchmarkApplication, SWT.NONE);
		btnBenchmark.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					statuslabel2.setText("");
					if (inputlist.isEmpty()){
						statuslabel2.setText("Please select atleast one Sorting Algorithm to Benchmark");
					}
					else{
						statuslabel2.setText("Benchmarking....Please wait...");
						BenchmarkApplication benchmarkApplication= new BenchmarkApplication(); 
						outputlist =benchmarkApplication.Benchmarkmethhod(inputlist,array);
						statuslabel2.setText("");
						Iterator<String> iterator = outputlist.iterator();
						while(iterator.hasNext()){
							statuslabel2.setText(statuslabel2.getText()+iterator.next()+"\n");
						}
						}
					
				} catch (Exception e1) {
					statuslabel2.setText("Please Generate a valid Array");
				}
			}
		});
		btnBenchmark.setBounds(40, 340, 186, 25);
		btnBenchmark.setText("Benchmark");
		
		Button btnBenchmarkAll = new Button(SortingBenchmarkApplication, SWT.NONE);
		btnBenchmarkAll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					if (array.length>0){
					btnBubbleSort.setSelection(false);
					btnSelectionSort.setSelection(false);
					btnQuickSort.setSelection(false);
					btnMergeSort.setSelection(false);
					btnInsertionSort.setSelection(false);
					statuslabel2.setText("Benchmarking....Please wait...");
					inputlist.add(btnBubbleSort.getText());
					inputlist.add(btnSelectionSort.getText());
					inputlist.add(btnInsertionSort.getText());
					inputlist.add(btnQuickSort.getText());
					inputlist.add(btnMergeSort.getText());
					BenchmarkApplication benchmarkApplication= new BenchmarkApplication(); 
						outputlist =benchmarkApplication.Benchmarkmethhod(inputlist,array);
						statuslabel2.setText("");
						Iterator<String> iterator = outputlist.iterator();
						while(iterator.hasNext()){
							statuslabel2.setText(statuslabel2.getText()+iterator.next()+"\n");
						}
					
					inputlist.clear();
					outputlist.clear();
					}
					else{
						statuslabel2.setText("Please Generate a valid Array");
						inputlist.clear();
						outputlist.clear();
						
					}
					
				} catch (Exception e1) {
					statuslabel2.setText("Please Generate a valid Array");
					inputlist.clear();
					outputlist.clear();
				}
				
			}
		});
		btnBenchmarkAll.setBounds(255, 340, 186, 25);
		btnBenchmarkAll.setText("BenchMark All");
	
		
		Button btnCancel = new Button(SortingBenchmarkApplication, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				SortingBenchmarkApplication.close();
			}
		});
		btnCancel.setBounds(366, 497, 75, 25);
		btnCancel.setText("Cancel");
		
		Button btnGenerate = new Button(SortingBenchmarkApplication, SWT.None);
		btnGenerate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			try {
				arraysize = Integer.parseInt(textarraysize.getText());
				BenchmarkApplication benchmarkApplication= new BenchmarkApplication();
				String str=benchmarkApplication.generateArray(arraytype, arraysize);
				array=benchmarkApplication.array;
				statuslabel1.setText(str);
			}catch (NumberFormatException e1) {
				statuslabel1.setText("Enter Integer value for size of array");
			}
			}
		});
		
		btnGenerate.setBounds(345, 89, 96, 25);
		btnGenerate.setText("Generate");
		
		Button btnReset = new Button(SortingBenchmarkApplication, SWT.NONE);
		btnReset.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				textarraysize.setText("");
				btnBest.setSelection(false);
				btnAverage.setSelection(false);
				btnWorst.setSelection(false);
				statuslabel1.setText("");
				btnBubbleSort.setSelection(false);
				btnSelectionSort.setSelection(false);
				btnQuickSort.setSelection(false);
				btnMergeSort.setSelection(false);
				btnInsertionSort.setSelection(false);
				statuslabel2.setText("");
				array=new int[0];
				}
		});
		btnReset.setBounds(280, 497, 75, 25);
		btnReset.setText("Reset");

	}
}
