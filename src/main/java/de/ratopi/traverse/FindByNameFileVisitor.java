package de.ratopi.traverse;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FindByNameFileVisitor implements FileVisitor
{
	private String filename;
	private List<File> files;

	public FindByNameFileVisitor( String filename )
	{
		this.filename = filename;
		this.files = new ArrayList<File>();
	}

	public List<File> getFiles()
	{
		return files;
	}

	public void visit( File file )
	{
		if ( filename.equals( file.getName() ) )
		{
			files.add( file );
		}
	}
}
