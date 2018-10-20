package de.ratopi.traverse;

import java.io.File;
import java.util.List;

public class MultipleFileVisitor implements FileVisitor
{
	private List<FileVisitor> fileVisitors;

	public MultipleFileVisitor( List<FileVisitor> fileVisitors )
	{
		this.fileVisitors = fileVisitors;
	}

	public List<FileVisitor> getFileVisitors()
	{
		return fileVisitors;
	}

	@Override
	public void visit( File file )
	{
		for ( FileVisitor fileVisitor : fileVisitors )
		{
			fileVisitor.visit( file );
		}
	}
}
