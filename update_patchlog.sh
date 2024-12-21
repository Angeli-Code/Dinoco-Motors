#!/bin/bash

# Script that automates the creation of a new .patch file. Intended to be used
# in between commits.

function create_patches_dir()
{
	mkdir -p docs/patches
}

function find_highest_patch()
{
	local highest=0

	for file in docs/patches/patch-*.diff; do
		{
			if [[ -f "${file}" ]]; then
				{
					num=$(echo "${file}" | sed 's/.*patch-\([0-9]*\).diff/\1/')
					if [[ "${num}" -gt "${highest}" ]]; then
						{
							highest="${num}"
						}
					fi
				}
			fi
		}
	done

	echo "${highest}"
}

function create_patch()
{
	local next=$1
	git diff --staged > "docs/patches/patch-${next}.diff"
}

function unstage_patch()
{
	local next=$1
	git reset "docs/patches/patch-${next}.diff"
}

function print_status()
{
	local next=$1
	echo "Created patch-${next}.diff in docs/patches/"
	echo "Patch file has been created and unstaged."
	echo "You can now proceed with your commits."
}

function main()
{
	create_patches_dir
	highest=$(find_highest_patch)
	next=$((highest + 1))
	create_patch "${next}"
	unstage_patch "${next}"
	print_status "${next}"
}

main
