# ClassMaps

ClassMaps is an container class for identifying classes and their dependencies.  

see also:  
* <a href="/docs/references/ClassMap.md">ClassMap</a>
## Constructor
<table>
	<tr>
		<td> Constructor </td>
		<td> Desctiption </td>
	</tr>
	<tr>
		<td>
			<code>ClassMaps()</code>
		</td>
		<td>
			Initializes empty instance
		</td>
	</tr>
</table>

## Public methods
<table>
	<tr>
		<td> Method </td>
		<td> Desctiption </td>
	</tr>
	<tr>
		<td>
			<code>void addClassMap(<a href="/docs/references/ClassMap.md">ClassMap</a> classMap)</code>
		</td>
		<td>
			Adds <a href="/docs/references/ClassMap.md">ClassMap</a> entity to the map.<br>
			When tool need to search for class,<br>
			It will search in this map too.
		</td>
	</tr>
	<tr>
		<td><code>
			List&lt;ClassMap&gt; getClassMapsBy(@Nullable Predicate&lt;ClassMap&gt;)
		</code></td>
		<td>
			Gets selected maps for processing. If <code>ppredicate</code> given as <code>null</code>,<br>
			Function will return all of the list.
		</td>
	</tr>
	<tr>
		<td><code>
			Optional&lt;ClassMap&gt; getClassMap(@NotNull Predicate&lt;ClassMap&gt;)
		</code></td>
		<td>
			Gets one selected map for processing if exists.
		</td>
	</tr>
</table>