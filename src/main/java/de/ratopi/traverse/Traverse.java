package de.ratopi.traverse;

import java.io.File;
import java.io.FileFilter;

/**
 * Traversing a file tree.
 */
public class Traverse
{
	private static FileFilter IS_DIR = new FileFilter()
	{
		public boolean accept( File file )
		{
			return file.isDirectory();
		}
	};

	private static FileFilter IS_FILE = new FileFilter()
	{
		public boolean accept( File file )
		{
			return file.isFile();
		}
	};

	/**
	 * Traverse the complete file tree starting with "path".
	 * fileVisitor is called for each file or directory
	 * @param path The root of the file tree to visit
	 * @param fileVisitor A FileVisitor which gets any of the files and directories in the file tree.
	 */
	public void traverse( final File path, final FileVisitor fileVisitor )
	{
		if ( !path.isDirectory() )
		{
			throw new IllegalArgumentException( "Path '" + path + "' is not a directory" );
		}

		for ( File file : path.listFiles( IS_FILE ) )
		{
			fileVisitor.visit( file );
		}

		for ( File dir : path.listFiles( IS_DIR ) )
		{
			traverse( dir, fileVisitor );
		}
	}
}
