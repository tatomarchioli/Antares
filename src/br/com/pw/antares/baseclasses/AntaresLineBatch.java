package br.com.pw.antares.baseclasses;

import java.util.ArrayList;
import java.util.List;

public abstract class AntaresLineBatch {
	private final List<AntaresLine> lines = new ArrayList<>();
	private int batchType;
	private String batchTag;
	private int batchSequence;
	private boolean include;

	protected AntaresLineBatch(int batchType, String batchTag, int sequence, boolean include) {
		setBatchType(batchType);
		setBatchTag(batchTag);
		setInclude(include);
		setBatchSequence(sequence);
	}

	public int getBatchType() {
		return batchType;
	}

	public void setBatchType(int batchType) {
		this.batchType = batchType;
	}

	public String getBatchTag() {
		return batchTag;
	}

	public void setBatchTag(String batchTag) {
		this.batchTag = batchTag;
	}

	public int getBatchSequence() {
		return batchSequence;
	}

	public void setBatchSequence(int batchSequence) {
		this.batchSequence = batchSequence;
	}

	public boolean isInclude() {
		return include;
	}

	public void setInclude(boolean include) {
		this.include = include;
	}

	public List<AntaresLine> getLines() {
		return lines;
	}

	public void addLine(AntaresLine line) {
		if (line == null) {
			throw new NullPointerException("Line nula");
		}
		this.lines.add(line);
	}

	public List<String> toLines() throws Exception {
		List<String> list = new ArrayList<>();
		try {
			for (AntaresLine line : lines) {
				list.add(line.toLine());
			}
		} catch (Exception e) {
			throw new Exception("[" + getBatchTag() + "] -> " + e.getMessage());
		}
		return list;
	}

	public abstract void fromLines(List<String> lines) throws Exception;

	public int getLineCount() {
		int i = 0;
		for(AntaresLine line : getLines()){
			i += line.isInclude() ? 1 : 0;
		}
		return i;
	}

	@Override
	public String toString() {
		String val = getBatchTag() + "{\n";
		for (AntaresLine field : getLines()) {
			val += "	" + field.toString();
			val += (getLines().indexOf(field) == getLines().size() - 1 ? "}" : ",\n");
		}
		return val;
	}

}
