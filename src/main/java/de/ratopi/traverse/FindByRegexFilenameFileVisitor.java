package de.ratopi.traverse;

import java.io.File;
import java.util.List;
import java.util.regex.Pattern;

public class FindByRegexFilenameFileVisitor implements FileVisitor
{
	private Pattern pattern;
	private List<File> files;

	public FindByRegexFilenameFileVisitor( final String regex )
	{
		this( Pattern.compile( regex ) );
	}

	public FindByRegexFilenameFileVisitor( final Pattern pattern )
	{
		this.pattern = pattern;
	}

	public List<File> getFiles()
	{
		return files;
	}

	@Override
	public void visit( File file )
	{
		if ( pattern.matcher( file.getName() ).matches() )
		{
			files.add( file );
		}
	}
}
